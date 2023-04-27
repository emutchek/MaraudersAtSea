package edu.vassar.cmpu203.maraudersatsea.model;
import edu.vassar.cmpu203.maraudersatsea.R;

public class ResourceArea extends ASurrounding {

    public ResourceArea() {
        symbol = R.drawable.smallbarrel;
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

    public int getResourceSymbol() {
        if (this.description.equals("rope")) {
            return R.drawable.rope;
        }
        if (this.description.equals("wood")) {
            return R.drawable.wood;
        }
        else return R.drawable.health;
    }

    public String displayCards(){
        return "Oh look! Some " + description + ". Do you want to grab it? (Q)";
    }

}


