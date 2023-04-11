package edu.vassar.cmpu203.maraudersatsea.model;

import java.util.ArrayList;

/*
 * A class to represent the grid on which the pirate ship navigates through
 * the world. The ship always remains at the bottom, and the scenery changes
 * around it.
 */
public class Grid {
    int ship_location = 0; //0-33
    int islandsMet = 0;
    public ASurrounding [][] grid;
    Island[] all_islands;



    public int getShipLocation() {
        return ship_location;
    }
    public ASurrounding executeMove() {
        ship_location++;
        addRA();
        ASurrounding left = grid[ship_location][0];
        ASurrounding right = grid[ship_location][1];

        if(left instanceof Island || right instanceof Island) {islandsMet++;}
        if (left instanceof Island || left instanceof ResourceArea) {
            return left;
        }
        else if (right instanceof Island || right instanceof ResourceArea) {
            return right;
        }
        else {
            return new ASurrounding();
        }
    }


    public Grid(Island[]islands) {
        this.all_islands = islands;
        ASurrounding blank = new ASurrounding();
        grid = new ASurrounding[][]{
                {blank, blank},
                {all_islands[0], blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {all_islands[1], blank},
                {blank, blank},
                {blank, blank},
                {blank, all_islands[2]},
                {blank, blank},
                {blank, blank},
                {all_islands[3], blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, all_islands[4]},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {all_islands[5], blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {all_islands[6], blank},
                {blank, blank},
                {blank, blank},
                {blank, all_islands[7]},
                {blank, blank},
                {blank, all_islands[8]},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {all_islands[9], blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank,all_islands[10]},
                {blank, blank},
                {all_islands[11], blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
                {blank, blank},
        };
    }

    /**
     * @return graphical representation of the grid filled with symbols
     */


    public boolean isBlank(ASurrounding s1){
        return (!(s1 instanceof Island) && !(s1 instanceof ResourceArea));
    }

    /**
     * Inserts resource areas at the top of the grid
     * - 1/4 chance that something is added
     * - 50/50 chance it's on left/right
     */
    public void addRA(){
        ASurrounding blank = new ASurrounding();
        if (isBlank(this.grid[ship_location + 4][0]) && isBlank(this.grid[ship_location + 4][1])){
            if (Math.random() < 0.25){
                if (Math.random() < 0.5){
                    this.grid[ship_location +4 ][0] = new ResourceArea();
                }
                else{
                    this.grid[ship_location +4 ][1] = new ResourceArea();
                }
            }
        }
    }

}

