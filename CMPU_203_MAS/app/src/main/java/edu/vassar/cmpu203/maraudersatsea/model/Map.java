package edu.vassar.cmpu203.maraudersatsea.model;

public class Map {
    Island[] all_islands;

    public Map(Island[] islands) {
        all_islands = islands;
    }

    public String toString() {
        String s = "";
        s += "MAP OF THE EASTERN ISLANDS\n"; //change name
        for(Island x : all_islands) {
            if(x.onMap) {
                s += x + "\n";
            }
        }
        return s;
    }

    public void addIsland(int x) {
        all_islands[x].onMap = true;
    }
}
