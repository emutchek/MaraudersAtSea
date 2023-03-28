package edu.vassar.cmpu203.maraudersatsea.view;

import android.view.View;

import androidx.annotation.NonNull;

import edu.vassar.cmpu203.maraudersatsea.model.Grid;

/**
 * Interface that defines the methods for a view that allows a user to add items to a sale.
 */
public interface IGridView {

    /**
     * Interface that classes interested in being notified of events happening
     * to the view should implement.
     */
    interface Listener {


    }

    /**
     * Returns the view at the root of the screen's graphical component hierarchy.
     *
     * @return the view at the root of the screen's graphical component hierarchy.
     */
    View getRootView();


}
