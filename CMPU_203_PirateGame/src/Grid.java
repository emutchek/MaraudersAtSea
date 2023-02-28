/*
 * A class to represent the grid on which the pirate ship navigates through
 * the world. The ship always remains at the bottom, and the scenery changes
 * around it.
 */
public class Grid {
    int ship_location = 0; //0-33
    int islands_met = 0;
    ASurrounding [][] grid;
    Island[] all_islands;


    public Grid(Island[]islands) {
        this.all_islands = islands;
        grid = new ASurrounding[][]{
                {null, null},
                {all_islands[0], null},
                {null, null},
                {null, null},
                {all_islands[1], null},
                {null, all_islands[2]},
                {null, null},
                {null, null},
                {all_islands[3], null},
                {null, null},
                {null, null},
                {null, all_islands[4]},
                {null, null},
                {null, null},
                {null, null},
                {all_islands[5], null},
                {null, null},
                {null, null},
                {null, null},
                {all_islands[6], null},
                {null, null},
                {null, null},
                {null, all_islands[7]},
                {null, null},
                {null, all_islands[8]},
                {null, null},
                {null, null},
                {null, null},
                {all_islands[9], null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
        };
    }

    public String toString() {
        String s = "";
        for(int r = this.ship_location + 4; r >= ship_location; r--) {
            if(r != ship_location) {
                s += "|" + toStringHelper(this.grid[r][0]) + "| |" + toStringHelper(this.grid[r][1]) + "|\n";
            }
            else {
                s += "|" + toStringHelper(this.grid[r][0]) + "|Δ|" + toStringHelper(this.grid[r][1]) + "|\n";
            }
        }
        return s;
    }

    private String toStringHelper(ASurrounding x){
        if (x == null){
            return " ";
        }
        else{
            return x.getSymbol();
        }
    }

    public void addRA(){
        if ((this.grid[ship_location + 4][0] == null) && (this.grid[ship_location + 4][1] == null)){
            if (Math.random() < 0.33){
                if (Math.random() < 0.5){
                    this.grid[ship_location +4 ][0] = new ResourceArea();
                }
                else{
                    this.grid[ship_location +4 ][1] = new ResourceArea();
                }
            }
        }
    }

    public Boolean move(){
        this.ship_location++;
        if(this.ship_location >= this.grid.length - 5) {
            return false;
        }
        addRA();
        return true;
    }

}
