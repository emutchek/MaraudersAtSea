package edu.vassar.cmpu203.maraudersatsea.view;

import edu.vassar.cmpu203.maraudersatsea.model.Grid;

public interface IMapView {

    /**
     * Interface that classes interested in being notified of events happening
     * to the view should implement.
     */
    interface Listener {
        void onSceneDone();
        Grid getGrid();

    }
}