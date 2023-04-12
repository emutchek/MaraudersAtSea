package edu.vassar.cmpu203.maraudersatsea.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GridTest {

    @Test
    /**
     * Tests executeMove() method in grid class by:
     * -verifying initial position is 0
     * -executing move, verifying that first island was identified and position changed
     * -executing 40 moves forward to verify that island 9 was identified, as an example
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

    /**
     * Tests addRA() method in grid class by:
     * -executing 55 moves forward, which calls add resource area each time
     * -examining the 2d array in grid and counting how many RAs were made
     * -verifying that the creation rate is around 25%
     */
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