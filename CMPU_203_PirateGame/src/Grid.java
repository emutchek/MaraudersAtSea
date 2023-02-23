/*
 * A class to represent the grid on which the pirate ship navigates through
 * the world. The ship always remains at the bottom, and the scenery changes
 * around it.
 */
public class Grid {
    int ship_location; //0-50
    ASurrounding [] all_surroundings = new ASurrounding[21]; //all islands & resource areas on world map
    String [][] grid;

    public Grid() {
        for(int i = 0; i < 21; i++) {
            all_surroundings [i] = new Island();
        }
        grid = new String [][]{
        {all_surroundings[0].toString(), " "},
        {" ", " "},
        {" ", all_surroundings[1].toString()},
        {all_surroundings[2].toString(), " "},
        {all_surroundings[3].toString(), " "},
        {" ", all_surroundings[4].toString()},
        {" ", " "},
        {" ", " "},
        {all_surroundings[5].toString(), " "},
        {" ", all_surroundings[6].toString()},
        {" ", " "},
        {" ", all_surroundings[7].toString()},
        {all_surroundings[8].toString(), " "},
        {" ", " "},
        {all_surroundings[9].toString(), " "},
        {all_surroundings[10].toString(), " "},
        {" ", " "},
        {" ", " "},
        {" ", " "},
        {all_surroundings[11].toString(), " "},
        {" ", all_surroundings[12].toString()},
        {" ", " "},
        {" ", all_surroundings[13].toString()},
        {" ", " "},
        {" ", all_surroundings[14].toString()},
        {" ", " "},
        {all_surroundings[15].toString(), " "},
        {" ", all_surroundings[16].toString()},
        {" ", " "},
        {" ", all_surroundings[17].toString()},
        {" ", " "},
        {" ", all_surroundings[18].toString()},
        {all_surroundings[19].toString(), " "},
        {" ", " "},
        {all_surroundings[20].toString(), " "}};
    }

    public String toString() {
        String s = "";
        for(int r = this.ship_location + 4; r < 5; r++) {
                s+= "|" + this.grid[r][0] + "| |" + this.grid[r][1] + "|\n";
        }
        return s;
    }

    public void populateGrid() {
        for (int r=this.ship_location + 4; r >= this.ship_location; r--){
            for (int c=0; c < 2; c++) {
                if(!(this.grid[r][c].equals("O"))) {//if this element isn't an island
                    this.grid[r][c] = "-"; //put something there
                }
            }
        }
    }
    public void move(){
        this.ship_location++;
        populateGrid();
        System.out.print(this);
    }
    public void identifyIslands() {}
}
