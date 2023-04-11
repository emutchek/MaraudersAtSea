package edu.vassar.cmpu203.maraudersatsea.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GridTest {

    @Test
    /**
     * Tests executeMove() method in grid class by creating a grid and moving forward.
     */
    void executeMove() {
        Library lib = new Library();
        Grid g = new Grid(lib.all_islands);
        assertEquals(0, g.ship_location, "ship loc. not 0");
        ASurrounding res = g.executeMove();
        assertEquals(res, lib.all_islands[0], "first island not returned");
        assertEquals(1, g.ship_location, "ship loc. not incremented");
        for(int i=0; i<=40; i++){
            res = g.executeMove();
        }
        assertEquals(res, lib.all_islands[9], "9th island not returned");
    }

    @Test
    void addRA() {
        Library lib = new Library();
        Grid g = new Grid(lib.all_islands);
        for(int i= 0; i<55; i++){
            g.executeMove();
        }
        double count = 0.0;
        for(int i=0; i<55; i++){
            for(int j=0; j<2; j++){
                if (g.grid[i][j] instanceof ResourceArea){
                    count++;
                }
            }
        }
        count/=50;
        assertTrue(((count >= .10) && (count<=.40)));
    }
}