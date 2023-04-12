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
    private GridViewFragment curGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainview = new MainView(this);
        setContentView(mainview.getRootView());

        curGame = new GridViewFragment(this);
        this.mainview.displayFragment(curGame, true, "gridview");
        this.lib = new Library();
        lib.setIslands();
        this.grid = new Grid(lib.all_islands);
    }

    /**
     * Returns the display cards of any surroundings the user encounters
     */
    public Grid onMove() {
       this.adj = grid.executeMove();
       return grid;
    }

    //if ship is next to island, pass that island's story scene to the fragment so it can display
    //all the proper text
    public void addressAdjacent() {
        if (this.adj instanceof Island) {
            Island island = (Island) this.adj;
            StoryViewFragment storyViewFragment = new StoryViewFragment(island.getStoryScene(), this);
            this.mainview.displayFragment(storyViewFragment, false, "storyscene");
        }
    }
    public void onSceneDone() {
        this.mainview.displayFragment(curGame, true, "gridview");
        updateGridView();
    }

    public void updateGridView(){
        ASurrounding[][] arr = grid.grid;
        int loc = grid.getShipLocation();

        //set image and tag for s4L and s4R
        int idDrawable = arr[loc+4][0].getSymbol();
        curGame.binding.s4L.setImageResource(idDrawable);
        curGame.binding.s4L.setTag(idDrawable);
        idDrawable = arr[loc+4][1].getSymbol();
        curGame.binding.s4R.setImageResource(idDrawable);
        curGame.binding.s4R.setTag(idDrawable);

        //set image and tag for s3L and s3R
        idDrawable = arr[loc+3][0].getSymbol();
        curGame.binding.s3L.setImageResource(idDrawable);
        curGame.binding.s3L.setTag(idDrawable);
        idDrawable = arr[loc+3][1].getSymbol();
        curGame.binding.s3R.setImageResource(idDrawable);
        curGame.binding.s3R.setTag(idDrawable);

        //set image and tag for s2L and s2R
        idDrawable = arr[loc+2][0].getSymbol();
        curGame.binding.s2L.setImageResource(idDrawable);
        curGame.binding.s2L.setTag(idDrawable);
        idDrawable = arr[loc+2][1].getSymbol();
        curGame.binding.s2R.setImageResource(idDrawable);
        curGame.binding.s2R.setTag(idDrawable);

        //set image and tag for s1L and s1R
        idDrawable = arr[loc+1][0].getSymbol();
        curGame.binding.s1L.setImageResource(idDrawable);
        curGame.binding.s1L.setTag(idDrawable);
        idDrawable = arr[loc+1][1].getSymbol();
        curGame.binding.s1R.setImageResource(idDrawable);
        curGame.binding.s1R.setTag(idDrawable);

        //set image and tag for s0L and s0R
        idDrawable = arr[loc][0].getSymbol();
        curGame.binding.s0L.setImageResource(idDrawable);
        curGame.binding.s0L.setTag(idDrawable);
        idDrawable = arr[loc][1].getSymbol();
        curGame.binding.s0R.setImageResource(idDrawable);
        curGame.binding.s0R.setTag(idDrawable);
    }
}