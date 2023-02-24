/*
 * A class to represent the grid on which the pirate ship navigates through
 * the world. The ship always remains at the bottom, and the scenery changes
 * around it.
 */
public class Grid {
    int ship_location = 0; //0-50
    ASurrounding [] all_islands = new ASurrounding[21]; //all islands on world map
    String [][] grid;

    public Grid() {
        for(int i = 0; i < 21; i++) {
            all_islands [i] = new Island();
        }
        grid = new String [][]{
        {" ", " "}, {all_islands[0].toString(), " "},
        {" ", all_islands[1].toString()},
        {all_islands[2].toString(), " "},
        {all_islands[3].toString(), " "},
        {" ", all_islands[4].toString()},
        {" ", " "},
        {" ", " "},
        {all_islands[5].toString(), " "},
        {" ", all_islands[6].toString()},
        {" ", " "},
        {" ", all_islands[7].toString()},
        {all_islands[8].toString(), " "},
        {" ", " "},
        {all_islands[9].toString(), " "},
        {all_islands[10].toString(), " "},
        {" ", " "},
        {" ", " "},
        {" ", " "},
        {all_islands[11].toString(), " "},
        {" ", all_islands[12].toString()},
        {" ", " "},
        {" ", all_islands[13].toString()},
        {" ", " "},
        {" ", all_islands[14].toString()},
        {" ", " "},
        {all_islands[15].toString(), " "},
        {" ", all_islands[16].toString()},
        {" ", " "},
        {" ", all_islands[17].toString()},
        {" ", " "},
        {" ", all_islands[18].toString()},
        {all_islands[19].toString(), " "},
        {" ", " "},
        {all_islands[20].toString(), " "}};
    }

    public String toString() {
        String s = "";
        for(int r = this.ship_location + 4; r >= ship_location; r--) {
            if(r != ship_location) {
                s += "|" + this.grid[r][0] + "| |" + this.grid[r][1] + "|\n";
            }
            else {
                s += "|" + this.grid[r][0] + "|Δ|" + this.grid[r][1] + "|\n";
            }
        }
        return s;
    }

    public void populateGrid() {
        for (int r=this.ship_location + 4; r >= this.ship_location; r--){
            for (int c=0; c < 2; c++) {
                if(!(this.grid[r][c].equals("Ѳ"))) {//if this element isn't an island
                    this.grid[r][c] = " "; //put something there
                }
            }
        }
    }
    public void move(){
        this.ship_location++;
        populateGrid();
        //System.out.print(this);
    }
    public void identifyIslands() {

    }
}
