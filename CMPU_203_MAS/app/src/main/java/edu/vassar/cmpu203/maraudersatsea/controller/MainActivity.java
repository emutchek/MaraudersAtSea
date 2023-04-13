package edu.vassar.cmpu203.maraudersatsea.controller;

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
import edu.vassar.cmpu203.maraudersatsea.view.StoryViewFragment;

public class MainActivity extends AppCompatActivity implements IGridView.Listener, IStoryView.Listener{
    IMainView mainview;
    public Grid grid;
    private Library lib;
    public ASurrounding adj;
    public GridViewFragment curGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainview = new MainView(this);
        setContentView(mainview.getRootView());
        this.lib = new Library();
        lib.setIslands();
        this.grid = new Grid(lib.all_islands);
        curGame = new GridViewFragment(this);
        this.mainview.displayFragment(curGame, true, "gridview");


    }

    /**
     * Returns the display cards of any surroundings the user encounters
     */
    public Grid onMove() {
       this.adj = grid.executeMove();
       return grid;
    }

    public Grid getGrid() {return grid;}

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
        this.mainview.displayFragment(curGame, true, "gridview");
        curGame.updateGridView(this.grid);
    }

}