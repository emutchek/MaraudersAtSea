package edu.vassar.cmpu203.maraudersatsea.view;

import android.content.Context;
import android.media.Image;
import android.provider.ContactsContract;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
//import android.support.v4.view.GestureDetectorCompat;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import edu.vassar.cmpu203.maraudersatsea.R;
import edu.vassar.cmpu203.maraudersatsea.model.Grid;
import edu.vassar.cmpu203.maraudersatsea.databinding.ActivityMainBinding;

/**
 * Implements GridView class.
 */

public class GridView implements IGridView {
    ActivityMainBinding binding; // reference to graphical widgets from xml layout
    Listener listener; // reference to the controller object associated with the view

    /**
     * Constructor method.
     *
     * @param context the context in which the screen is to be created - influences colors, fonts, etc
     */
    public GridView(@NonNull Context context, @NonNull Listener listener) {

        this.listener = listener; // take note of listener (controller) object

        // inflate the layout
        this.binding = ActivityMainBinding.inflate(LayoutInflater.from(context));

        // add click listener to add item button
        this.binding.inventoryButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Listener method to be called when the inventory button is clicked.
             *
             * @param view the view that was clicked on
             */
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Got here", Snackbar.LENGTH_LONG).show();

            }
        }
        );
        // add click listener to add item button
        this.binding.moveButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Listener method to be called when the move button is clicked.
             *
             * @param view the view that was clicked on
             */
            @Override
            public void onClick(View view) {
              //  GridView.this.binding.s4L.setImageResource(getImage(1));
                updateGridView(GridView.this.listener.onMoveView());
                //String surroundingText = GridView.this.listener.onMoveDisplayCards();
                //Snackbar.make(view, surroundingText, Snackbar.LENGTH_LONG).show();
            }
        }
        );

    }

    /*
    Returns the drawable associated with the int
     */
    public int getImage(int n){
        switch(n){
            case (1):
                return R.drawable.island;
            case(2):
                return R.drawable.barrel1;
            default:
                return R.color.teal_700;
        }
    }
    public void updateGridView(ArrayList lst){
        this.binding.s4L.setImageResource(getImage(lst.indexOf(0)));
        this.binding.s4R.setImageResource(getImage(lst.indexOf(1)));
        this.binding.s3L.setImageResource(getImage(lst.indexOf(2)));
        this.binding.s3R.setImageResource(getImage(lst.indexOf(3)));
        this.binding.s2L.setImageResource(getImage(lst.indexOf(4)));
        this.binding.s2R.setImageResource(getImage(lst.indexOf(5)));
        this.binding.s1L.setImageResource(getImage(lst.indexOf(6)));
        this.binding.s1R.setImageResource(getImage(lst.indexOf(7)));
        this.binding.s0L.setImageResource(getImage(lst.indexOf(8)));
        this.binding.s0R.setImageResource(getImage(lst.indexOf(9)));
    }


}
