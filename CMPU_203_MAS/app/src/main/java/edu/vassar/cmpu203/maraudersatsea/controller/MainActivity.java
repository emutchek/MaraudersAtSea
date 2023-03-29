package edu.vassar.cmpu203.maraudersatsea.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.vassar.cmpu203.maraudersatsea.R;
import edu.vassar.cmpu203.maraudersatsea.view.GridView;
import edu.vassar.cmpu203.maraudersatsea.view.IGridView;


public class MainActivity extends AppCompatActivity implements IGridView.Listener{
    IGridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gridview = new GridView(this, this);
        setContentView(R.layout.activity_main);
    }

    /**
     * React to the user moving forward
     */
    void onMove() {

    }
}