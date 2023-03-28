package edu.vassar.cmpu203.maraudersatsea.view;
import android.content.Context;
import android.provider.ContactsContract;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.maraudersatsea.R;
import edu.vassar.cmpu203.maraudersatsea.model.Grid;
import edu.vassar.cmpu203.maraudersatsea.databinding.ActivityMainBinding;


/**
 * Implements GridView class.
 */

public class GridView implements IGridView{
    ActivityMainBinding binding; // reference to graphical widgets from xml layout
    Listener listener; // reference to the controller object associated with the view

    /**
     * Constructor method.
     * @param context the context in which the screen is to be created - influences colors, fonts, etc
     */
    public GridView(@NonNull Context context, @NonNull Listener listener){

        this.listener = listener; // take note of listener (controller) object

        // inflate the layout
        this.binding = ActivityMainBinding.inflate(LayoutInflater.from(context));

        // add click listener to add item button
        this.binding.inventoryButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Listener method to be called when the add item button is clicked.
             *
             * @param view the view that was clicked on
             */
            @Override
            public void onClick(View view) {


            }
        });

    }
    /**
     * Returns the view at the root of the screen's graphical component hierarchy.
     *
     * @return the view at the root of the screen's graphical component hierarchy.
     */
    @Override
    public View getRootView() {
        return this.binding.getRoot();
    }



}
