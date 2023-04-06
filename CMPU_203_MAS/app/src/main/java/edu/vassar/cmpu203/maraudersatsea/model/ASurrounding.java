package edu.vassar.cmpu203.maraudersatsea.model;

import edu.vassar.cmpu203.maraudersatsea.R;

/*
 * An abstract class to represent any physical object or landmass that
 * the ship passes by, represented as Island objects and ResourceAreas objects.
 */
public class ASurrounding {
    String description;
    int symbol = (R.color.trans);

    public int getSymbol(){
        return symbol;
    }

}

