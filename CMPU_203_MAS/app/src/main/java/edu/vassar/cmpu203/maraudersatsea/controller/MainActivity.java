package edu.vassar.cmpu203.maraudersatsea.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.vassar.cmpu203.maraudersatsea.R;
import edu.vassar.cmpu203.maraudersatsea.model.ASurrounding;
import edu.vassar.cmpu203.maraudersatsea.model.Grid;
import edu.vassar.cmpu203.maraudersatsea.model.Inventory;
import edu.vassar.cmpu203.maraudersatsea.model.Island;
import edu.vassar.cmpu203.maraudersatsea.model.Library;
import edu.vassar.cmpu203.maraudersatsea.model.Obstacle;
import edu.vassar.cmpu203.maraudersatsea.model.ResourceArea;
import edu.vassar.cmpu203.maraudersatsea.model.Ship;
import edu.vassar.cmpu203.maraudersatsea.view.GridViewFragment;
import edu.vassar.cmpu203.maraudersatsea.view.HomeViewFragment;
import edu.vassar.cmpu203.maraudersatsea.view.IGridView;
import edu.vassar.cmpu203.maraudersatsea.view.IHomeView;
import edu.vassar.cmpu203.maraudersatsea.view.IMainView;
import edu.vassar.cmpu203.maraudersatsea.view.IObstacleView;
import edu.vassar.cmpu203.maraudersatsea.view.IResourceArea;
import edu.vassar.cmpu203.maraudersatsea.view.IStoryView;
import edu.vassar.cmpu203.maraudersatsea.view.MainView;
import edu.vassar.cmpu203.maraudersatsea.view.MaraudersFragFactory;
import edu.vassar.cmpu203.maraudersatsea.view.ObstacleViewFragment;
import edu.vassar.cmpu203.maraudersatsea.view.StoryViewFragment;
import edu.vassar.cmpu203.maraudersatsea.view.ResourceAreaFragment;


public class MainActivity extends AppCompatActivity implements IGridView.Listener, IStoryView.Listener
, IResourceArea.Listener, IObstacleView.Listener, IHomeView.Listener {
    IMainView mainview;
    public Grid curGrid;
    private Library lib;
    public Inventory inv;
    public Ship ship;
    Obstacle tempObs = new Obstacle();
    public int doubt = 0;

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
        lib.setIslands();
        this.inv = new Inventory();
        this.ship = new Ship();

        this.mainview.displayFragment(new HomeViewFragment(this),true,"homeview");

        //not rebuilding - display from start
        if(savedInstanceState == null){
            this.curGrid = new Grid(lib.all_islands);
            this.mainview.refreshStats(inv.toString(), ship.toString());
        }
        //retrieve old grid
        else{
            this.curGrid = (Grid) savedInstanceState.getSerializable(CUR_GAME);
        }
        this.mainview.removeInfoBar();
    }

    public void launchGrid(Bundle savedInstanceState) {
        //not rebuilding - display from start
        if(savedInstanceState == null){
            this.curGrid = new Grid(lib.all_islands);
            this.mainview.displayFragment(new GridViewFragment(this), true, "gridview");
            this.mainview.refreshStats(inv.toString(), ship.toString());
        }
        //retrieve old grid
        else{
            this.curGrid = (Grid) savedInstanceState.getSerializable(CUR_GAME);
        }
    }

    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(CUR_GAME, this.curGrid);
    }

    /**
     * Returns the display cards of any surroundings the user encounters
     */
    public Grid onMove() {
        this.adjustStories();
       this.adj = curGrid.executeMove();
       return curGrid;
    }

    public Grid getGrid() {return curGrid;}

    public Inventory getInv() {return inv;}

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

    //if ship is next to island, pass that island's story scene to the fragment so it can display
    //all the proper text
    public void addressAdjacent() {
        if (this.adj instanceof Island) {
            Island island = (Island) this.adj;
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
            if (tempObs != null){
                ObstacleViewFragment obsFragment = new ObstacleViewFragment(tempObs, this);
                this.mainview.displayFragment(obsFragment, false, "obstacle");
            }
        }

    }
    public void addressIsland() {
        doubt++;
        //if they choose not to send in the map, they get shown the good ending regardless of their doubt
        if(curGrid.islandsMet == 11) {
            curGrid.all_islands[11].story = lib.all_secstories[11];
        }
    }

    /**
     * Chooses random obstacle from the list, 10% of the time
     * @return text of an obstacle, or null
     */
    public void generateObstacle() {
        if(Math.random() <= 0.2) {
            int randIndex = (int)(Math.random() * 5);
            tempObs = lib.all_obstacles.get(randIndex);
            //lib.all_obstacles.remove(tempObs);
        }
        else{
            tempObs = null;
        }
    }
    /**
     * Carries out effects of poor decisions by decrementing ship health
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
                ship.updateHealth(-25);
                break;
        }
        updateInfoBar();
    }

    /**
     * Carries out effects of when user chooses to address obstacle by consuming resources
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
                    ship.updateHealth(25);
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
                ship.updateHealth(-25);
                break;
        }
        updateInfoBar();
    }

    public void updateInfoBar(){this.mainview.refreshStats(inv.toString(), ship.toString());}


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
        }
    }

    public String gameOver(){
        if (ship.health <= 0) {
            return "died";
        }
        else if (curGrid.islandsMet >= 12) {
            return "over";
        }
        return "continue";
    }

}