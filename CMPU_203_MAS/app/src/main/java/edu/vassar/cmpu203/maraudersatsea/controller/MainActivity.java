package edu.vassar.cmpu203.maraudersatsea.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.vassar.cmpu203.maraudersatsea.model.ASurrounding;
import edu.vassar.cmpu203.maraudersatsea.model.Grid;
import edu.vassar.cmpu203.maraudersatsea.model.Island;
import edu.vassar.cmpu203.maraudersatsea.model.Library;
import edu.vassar.cmpu203.maraudersatsea.view.GridViewFragment;
import edu.vassar.cmpu203.maraudersatsea.view.IGridView;
import edu.vassar.cmpu203.maraudersatsea.view.IMainView;
import edu.vassar.cmpu203.maraudersatsea.view.IStoryView;
import edu.vassar.cmpu203.maraudersatsea.view.MainView;
import edu.vassar.cmpu203.maraudersatsea.view.MaraudersFragFactory;
import edu.vassar.cmpu203.maraudersatsea.view.StoryViewFragment;

public class MainActivity extends AppCompatActivity implements IGridView.Listener, IStoryView.Listener{
    IMainView mainview;
    public Grid curGrid;
    private Library lib;
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

        //not rebuilding - display from start
        if(savedInstanceState == null){
            this.curGrid = new Grid(lib.all_islands);
            this.mainview.displayFragment(new GridViewFragment(this), true, "gridview");
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
       this.adj = curGrid.executeMove();
       return curGrid;
    }

    public Grid getGrid() {return curGrid;}

    //if ship is next to island, pass that island's story scene to the fragment so it can display
    //all the proper text
    public void addressAdjacent() {
        if (this.adj instanceof Island) {
            Island island = (Island) this.adj;
            StoryViewFragment storyViewFragment = new StoryViewFragment(island.getStoryScene(), this);
            this.mainview.displayFragment(storyViewFragment, true, "storyscene");
        }
    }
    public void onSceneDone() {
        Bundle args = GridViewFragment.makeArgsBundle(curGrid.getShipLocation());
        GridViewFragment gridviewfragment = new GridViewFragment(this);
        gridviewfragment.setArguments(args);
        this.mainview.displayFragment(gridviewfragment, true, "gridview");
    }
}