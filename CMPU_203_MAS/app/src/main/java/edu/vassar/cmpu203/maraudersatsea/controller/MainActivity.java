package edu.vassar.cmpu203.maraudersatsea.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.vassar.cmpu203.maraudersatsea.model.ASurrounding;
import edu.vassar.cmpu203.maraudersatsea.model.Grid;
import edu.vassar.cmpu203.maraudersatsea.model.Inventory;
import edu.vassar.cmpu203.maraudersatsea.model.Island;
import edu.vassar.cmpu203.maraudersatsea.model.Library;
import edu.vassar.cmpu203.maraudersatsea.model.Map;
import edu.vassar.cmpu203.maraudersatsea.model.Obstacle;
import edu.vassar.cmpu203.maraudersatsea.model.ResourceArea;
import edu.vassar.cmpu203.maraudersatsea.view.GridViewFragment;
import edu.vassar.cmpu203.maraudersatsea.view.HomeViewFragment;
import edu.vassar.cmpu203.maraudersatsea.view.IGridView;
import edu.vassar.cmpu203.maraudersatsea.view.IHomeView;
import edu.vassar.cmpu203.maraudersatsea.view.IMainView;
import edu.vassar.cmpu203.maraudersatsea.view.IMapView;
import edu.vassar.cmpu203.maraudersatsea.view.IObstacleView;
import edu.vassar.cmpu203.maraudersatsea.view.IResourceArea;
import edu.vassar.cmpu203.maraudersatsea.view.IStoryView;
import edu.vassar.cmpu203.maraudersatsea.view.MainView;
import edu.vassar.cmpu203.maraudersatsea.view.MapViewFragment;
import edu.vassar.cmpu203.maraudersatsea.view.MaraudersFragFactory;
import edu.vassar.cmpu203.maraudersatsea.view.ObstacleViewFragment;
import edu.vassar.cmpu203.maraudersatsea.view.StoryViewFragment;
import edu.vassar.cmpu203.maraudersatsea.view.ResourceAreaFragment;


public class MainActivity extends AppCompatActivity implements IGridView.Listener, IStoryView.Listener
, IResourceArea.Listener, IObstacleView.Listener, IHomeView.Listener, IMapView.Listener {
    IMainView mainview;
    public Grid curGrid;
    private Library lib;
    public Map map;
    public Inventory inv;
    Obstacle tempObs = new Obstacle();
    public int doubt = 0;

    public int health = 100;

    public ASurrounding adj;
    public GridViewFragment curFrag;


    private static final String CUR_GAME = "curGame";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportFragmentManager().setFragmentFactory(new MaraudersFragFactory(this));

        super.onCreate(savedInstanceState);
        mainview = new MainView(this);
        setContentView(mainview.getRootView());

        this.lib = new Library();
        this.map = new Map(this.lib.all_islands);
        lib.setIslands();
        this.inv = new Inventory();

        this.mainview.displayFragment(new HomeViewFragment(this),true,"homeview");

        //not rebuilding - display from start
        if(savedInstanceState == null){
            this.curGrid = new Grid(lib.all_islands);
            this.mainview.refreshStats(inv.toString(), shipString());
        }
        //retrieve old grid
        else{
            this.curGrid = (Grid) savedInstanceState.getSerializable(CUR_GAME);
        }
        this.mainview.removeInfoBar();
    }

    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(CUR_GAME, this.curGrid);
    }


    public void updateHealth(int amt){
        int temphealth = this.health+amt;
        if(temphealth <= 100 && temphealth >= 0) {
            health = temphealth;
        } else if (temphealth < 0) {
            health = 0;
        }
        else if (temphealth > 100){
            health = 100;
        }
    }

    public String shipString(){
        return "Ship health: " + health;
    }

    /**
     * Whenever the ship moves forwards, this method:
     * - checks whether a change should be made to the plot
     * - physically moves the ship forward
     * - returns the display cards of any surroundings the user encounters
     */
    public Grid onMove() {
        this.adjustStories();
       this.adj = curGrid.executeMove();
       return curGrid;
    }

    public Grid getGrid() {return curGrid;}

    public Inventory getInv() {return inv;}

    /**
     * When the user is midway through the game, this method uses their decision-making record
     * so far to determine which story branch they will follow and updates islands accordingly
     */
    public void adjustStories() {
        if(curGrid.islandsMet == 7){
            if(doubt >= 2){
                //change The Grove story text to be the Meeting Place text
                curGrid.all_islands[8].setStory(lib.all_secstories[8]);
            }
        }
        if(curGrid.islandsMet == 9) {
            if(doubt < 2) {
                //remove the question from you've got mail
                curGrid.all_islands[10].story.question = "N/A";
            }
        }
    }

    /**
     * If the ship has sailed up to an object, this method launches the appropriate screen for it
     * - if by an island, show the corresponding story and update island count
     * - if by a resource area, show the pop-up screen asking them to pick it up
     * - if at an obstacle, show the description of the problem and possible solutions
     */
    public void addressAdjacent() {
        if (this.adj instanceof Island) {
            Island island = (Island) this.adj;
            if(this.curGrid.islandsMet < 11) {this.map.addIsland(this.curGrid.islandsMet);}
            StoryViewFragment storyViewFragment = new StoryViewFragment(island.getStoryScene(), this);
            this.mainview.displayFragment(storyViewFragment, true, "storyscene");
        }
        else if(this.adj instanceof ResourceArea) {
            ResourceArea ra = (ResourceArea) this.adj;
            ResourceAreaFragment raFragment = new ResourceAreaFragment(ra, this);
            this.mainview.displayFragment(raFragment, true, "resourcearea");
        }
        else{
            this.generateObstacle();
            //hard codes an obstacle into
            if(curGrid.getShipLocation() == 2) {guaranteeObstacle();}
            if (tempObs != null){
                ObstacleViewFragment obsFragment = new ObstacleViewFragment(tempObs, this);
                this.mainview.displayFragment(obsFragment, false, "obstacle");
            }
        }

    }

    /**
     * Implements effects of user making a 'bad' story decision
     * - updates metric about their morality
     * - swaps in the 'bad' ending of the game if they've made enough poor decisions
     */
    public void addressIsland() {
        doubt++;
        //if they choose not to send in the map, they get shown the good ending regardless of their doubt
        if(curGrid.islandsMet == 11) {
            curGrid.all_islands[11].story = lib.all_secstories[11];
        }
    }

    /**
     * Launches the map fragment
     */
    public void openMap() {
        MapViewFragment mapViewFragment = new MapViewFragment(this.map, this);
        this.mainview.displayFragment(mapViewFragment, true, "map");
    }

    /**
     * Chooses random obstacle from the list to present to the user (only occurs 20% of the time)
     */
    public void generateObstacle() {
        if(Math.random() <= 0.2) {
            int randIndex = (int)(Math.random() * 7);
            tempObs = lib.all_obstacles.get(randIndex);
            //lib.all_obstacles.remove(tempObs);
        }
        else{
            tempObs = null;
        }
    }

    public void guaranteeObstacle() {
        tempObs = lib.all_obstacles.get(0);
    }
    /**
     * Carries out effects of user's solution to an obstacle
     * -may decrement ship health
     * -may consume a resource
     *  @param x index of which obstacle the user is facing
     */
    public void performSolutionA(int x) {
        switch (x) {
            //(wo)man overboard
            case 4:
                break;
            case 5:
                if(inv.medicine == 0) {
                    inv.removeInventory('M');
                    break;
                }
                else {performSolutionB(x);}
                break;
            default:
                updateHealth(-25);
                break;
        }
        updateInfoBar();
    }

    /**
     * Carries out effects of user's solution to an obstacle
     *      * -may decrement ship health
     *      * -may consume a resource
     * If they don't have the resources required, it executes the other option automatically
     * @param x index of which obstacle the user is facing
     */
    public void performSolutionB (int x) {
        switch (x) {
            case 0:
            case 1:
                if(inv.medicine == 0) {performSolutionA(x);}
                else {
                    inv.removeInventory('M');
                    updateHealth(25);
                }
                break;

            case 2:
            case 3:
                if(inv.wood < 10) {performSolutionA(x);}
                else {
                    inv.removeInventory('W');
                }
                break;

            case 4:
                if(inv.rope == 0) {performSolutionA(x);}
                else {
                    inv.removeInventory('R');
                }
                break;
            case 6:
                if(inv.medicine == 0 || inv.rope == 0 || inv.wood == 0) {performSolutionA(x);}
                else {
                    inv.removeInventory('R');
                    inv.removeInventory('W');
                    inv.removeInventory('M');
                }
                break;
            //cases where B was wrong - 4 (woman overboard), 5 (sound of sirens)
            default:
                updateHealth(-25);
                break;
        }
        updateInfoBar();
    }

    /**
     * Updates the inventory and health at the bottom of screen with more up-to-date numbers
     */
    public void updateInfoBar(){this.mainview.refreshStats(inv.toString(), shipString());}

    /**
     * Transitions out of a pop-up back into the regular grid view
     * -Determines where the ship should be on the map
     * -Updates the info bar at the bottom of the screen
     *
     * If the game is over (or the user has died), it launches the home screen again
     */
    public void onSceneDone() {
        Bundle args = GridViewFragment.makeArgsBundle(curGrid.getShipLocation());
        GridViewFragment gridviewfragment = new GridViewFragment(this);
        gridviewfragment.setArguments(args);
        this.mainview.displayFragment(gridviewfragment, true, "gridview");
        updateInfoBar();
        tempObs = null;
        String gameStatus = gameOver();
        if (!gameStatus.equals("continue")){
            HomeViewFragment homeviewfragment = new HomeViewFragment(this);
            this.mainview.displayFragment(homeviewfragment, false, "homeview");
            this.mainview.removeInfoBar();
        }
    }

    /**
     * Checks whether the user has died or reached the end of the game
     * @return a string indicating whether to keep going, show the lose message, or show home screen
     */
    public String gameOver(){
        if (health <= 0) {
            return "died";
        }
        else if (curGrid.islandsMet >= 12) {
            return "over";
        }
        return "continue";
    }

    /**
     * Resets game state for when a player finishes and wants to play again
     */
    public void restart(){
        this.lib = new Library();
        lib.setIslands();
        this.inv = new Inventory();
        this.curGrid = new Grid(lib.all_islands);
        this.mainview.refreshStats(inv.toString(), shipString());
        doubt = 0;
    }

}