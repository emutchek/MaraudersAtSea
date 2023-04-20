package edu.vassar.cmpu203.maraudersatsea.view;

import edu.vassar.cmpu203.maraudersatsea.model.Inventory;

public interface IResourceArea {
    /**
     * Interface that classes interested in being notified of events happening
     * to the view should implement.
     */
    interface Listener {
        Inventory getInv();
        void onSceneDone();
    }
}
