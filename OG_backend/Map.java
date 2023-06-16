package edu.vassar.cmpu203.maraudersatsea.model;

public class Map {
    Island[] all_islands;

    public Map(Island[] islands) {
        all_islands = islands;
    }

    public void addIsland(int x) {
        all_islands[x].onMap = true;
    }

}
