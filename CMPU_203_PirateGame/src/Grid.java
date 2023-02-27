/*
 * A class to represent the grid on which the pirate ship navigates through
 * the world. The ship always remains at the bottom, and the scenery changes
 * around it.
 */
public class Grid {
    int ship_location = 0; //0-50
    String [][] grid;
    Island[] all_islands = new Island[10];
    int islands_met = 0;

    public Grid(Island[]all_islands) {
        this.all_islands = all_islands;
        grid = new String [][]{
        {" ", " "}, {all_islands[0].toString(), " "},
        {" ", " "},
        {" ", " "},
        {all_islands[1].toString(), " "},
        {" ", all_islands[2].toString()},
        {" ", " "},
        {" ", " "},
        {all_islands[3].toString(), " "},
        {" ", " "},
        {" ", " "},
        {" ", all_islands[4].toString()},
        {" ", " "},
        {" ", " "},
        {" ", " "},
        {all_islands[5].toString(), " "},
        {" ", " "},
        {" ", " "},
        {" ", " "},
        {all_islands[6].toString(), " "},
        {" ", " "},
        {" ", " "},
        {" ", all_islands[7].toString()},
        {" ", " "},
        {" ", all_islands[8].toString()},
        {" ", " "},
        {" ", " "},
        {" ", " "},
        {" ", " "},
        {" ", " "},
        {" ", " "},
        {all_islands[9].toString()," ", },
        {" ", " "},
        {" ", " "},
        {" ", " "}};
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
    public boolean move(){
        this.ship_location++;
        if(this.ship_location >= this.grid.length - 5) {
            return false;
        }
        populateGrid();
        System.out.print(this);
        identifyIslands();
        return true;
    }
    public void identifyIslands() {
        if(this.grid[ship_location][0].equals("Ѳ") ||
                this.grid[ship_location][1].equals("Ѳ")){
            all_islands[islands_met].story.displayCards();
            this.islands_met ++;
        }
    }
}