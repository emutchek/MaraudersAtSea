package edu.vassar.cmpu203.maraudersatsea.model;

/*
 * An abstract class to represent any physical object or landmass that
 * the ship passes by, represented as Island objects and ResourceAreas objects.
 */
public abstract class ASurrounding {
    String description;
    String symbol;

    public abstract String getSymbol();

}

