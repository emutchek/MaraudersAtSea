package edu.vassar.cmpu203.maraudersatsea.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import edu.vassar.cmpu203.maraudersatsea.R;
import edu.vassar.cmpu203.maraudersatsea.model.Grid;
import edu.vassar.cmpu203.maraudersatsea.model.Library;
import edu.vassar.cmpu203.maraudersatsea.view.GridView;
import edu.vassar.cmpu203.maraudersatsea.view.IGridView;


public class MainActivity extends AppCompatActivity implements IGridView.Listener{
    IGridView gridview;
    private Grid grid;
    private Library lib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gridview = new GridView(this, this);
        setContentView(R.layout.activity_main);
        this.lib = new Library();
        this.grid = new Grid(lib.all_islands);
    }

    /**
     * Returns the display cards of any surroundings the user encounters
     */
    public String onMoveDisplayCards() {
        String surroundingText = grid.moveDisplayCards();
        return surroundingText;
    }

    /**
     * Returns integer indicating appropriate image
     * 0- ocean; 1- island; 2-Resource Area
     */
    public ArrayList onMoveView() {
        ArrayList<Integer> numbers = grid.moveView();
        return numbers;
    }
}