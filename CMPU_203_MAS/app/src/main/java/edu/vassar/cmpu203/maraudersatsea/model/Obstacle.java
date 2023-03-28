package edu.vassar.cmpu203.maraudersatsea.model;

public class Obstacle {
    String text;
    String [] options;
    String [] results;
    int code;
    //0: disease - option A means use medicine + gain health, option B means lose health
    //1: mast break - option A means use rope + lose health, option B means use wood + gain health

    public Obstacle (String t, String [] o, String[] r, int c) {
        text = t;
        options = o;
        results = r;
        code = c;
    }

    public Obstacle() {}

    public String toString() {
        return "OBSTACLE:\n" + text + "\n\nChoose action A or B\n\nA: " + options[0] + "\nor\nB: " + options[1];
    }

    public String returnObsEnding(char x){
        if (x=='A'){
            return this.results[0];
        }
        else{
            return this.results[1];
        }
    }


}
