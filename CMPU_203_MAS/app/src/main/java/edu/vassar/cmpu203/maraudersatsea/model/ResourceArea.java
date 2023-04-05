package edu.vassar.cmpu203.maraudersatsea.model;
import edu.vassar.cmpu203.maraudersatsea.R;

public class ResourceArea extends ASurrounding {

    public ResourceArea() {
        symbol = R.drawable.ra_pic;
        double x = Math.random();
        if (x <= 0.33) {
            description = "rope";
        } else if (x <= 0.67) {
            description = "wood";
        } else {
            description = "medicine";
        }
    }

    public int getSymbol() {
        return symbol;
    }

    public String displayCards(){
        return "Oh look! Some " + description + ". Do you want to grab it? A for yes, B for no (Q)";
    }

}


