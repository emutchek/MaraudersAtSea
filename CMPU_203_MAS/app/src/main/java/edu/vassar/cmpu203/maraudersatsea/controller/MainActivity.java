package edu.vassar.cmpu203.maraudersatsea.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.vassar.cmpu203.maraudersatsea.model.Grid;
import edu.vassar.cmpu203.maraudersatsea.model.Library;
import edu.vassar.cmpu203.maraudersatsea.view.GridViewFragment;
import edu.vassar.cmpu203.maraudersatsea.view.IGridView;
import edu.vassar.cmpu203.maraudersatsea.view.IMainView;
import edu.vassar.cmpu203.maraudersatsea.view.MainView;

public class MainActivity extends AppCompatActivity implements IGridView.Listener{
    IMainView mainview;
    private Grid grid;
    private Library lib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainview = new MainView(this);
        setContentView(mainview.getRootView());
        this.mainview.displayFragment(new GridViewFragment(this), true, "gridView");
        this.lib = new Library();
        this.grid = new Grid(lib.all_islands);
    }

    /**
     * Returns the display cards of any surroundings the user encounters
     */
    public Grid onMove() {
       grid.executeMove();
        return grid;
    }


}