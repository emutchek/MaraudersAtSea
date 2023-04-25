package edu.vassar.cmpu203.maraudersatsea.view;

public interface IObstacleView {

    /**
     * Interface that classes interested in being notified of events happening
     * to the view should implement.
     */
    interface Listener {
        void onSceneDone();
        void performSolutionA(int x);
        void performSolutionB(int x);
        void generateObstacle();
    }
}
