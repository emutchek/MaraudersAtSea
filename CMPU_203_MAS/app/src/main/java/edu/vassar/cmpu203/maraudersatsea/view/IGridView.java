package edu.vassar.cmpu203.maraudersatsea.view;

import android.view.View;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import edu.vassar.cmpu203.maraudersatsea.model.ASurrounding;
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
        Grid onMove();
    }
}
