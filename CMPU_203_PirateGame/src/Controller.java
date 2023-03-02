import java.util.ArrayList;
public class Controller {
    Library lib = new Library();
    Ship s = new Ship();
    Inventory inv = new Inventory();

    Map m = new Map(lib.getIslands());
    Grid g = new Grid(lib.getIslands());

    int doubt = 0;
    ArrayList<String> moveOps = new ArrayList<String>();
    ArrayList<String> invOps = new ArrayList<String>();

    public Controller() {
        moveOps.add("M");
        moveOps.add("W");
        moveOps.add("I");
        moveOps.add("Q");
        moveOps.add("H");

        invOps.add("M");
        invOps.add("W");
        invOps.add("R");
        invOps.add("C");
    }




    public Boolean isValid(ArrayList<String> options, char c) {
        return options.contains(String.valueOf(c));
    }

    public String respondInput(char act) {
        switch (act) {
            case ('M'):
                return m.toString();
            case ('H'):
                return s.toString();
            case ('I'):
                return inv.toString();
            default:
                return "null";
        }
    }

    public String makeMove() {
        if (!g.move()) {
            return "null";
        }
        ASurrounding left = g.grid[g.ship_location][0];
        ASurrounding right = g.grid[g.ship_location][1];
        String ret = g.toString();
        //check if the ship is next to an island
        if (left instanceof Island) {
            ret += ((Island) left).displayCards();
        } else if (right instanceof Island) {
            ret += ((Island) right).displayCards();
        }
        //check if ship is next to a resource area
        else if (left instanceof ResourceArea) {
            ret += ((ResourceArea) left).displayCards();
        } else if (right instanceof ResourceArea) {
            ret += ((ResourceArea) right).displayCards();
        }

        return ret;
    }

    public boolean addressResource(char choice) {
        ASurrounding left = g.grid[g.ship_location][0];
        ASurrounding right = g.grid[g.ship_location][1];
        //they want to add something
        if (choice == 'A') {
            //inventory is full
            if(inv.isFull()) {
                return false;
            }
            if (left instanceof ResourceArea) {
                inv.addToInventory((ResourceArea) left);
            }
            if (right instanceof ResourceArea) {
                inv.addToInventory((ResourceArea) right);
            }

        }
        return true;
    }

    public void callRemoveInventory(char c) {
        inv.removeInventory(c);
    }

    public void addressIsland(char choice) {
        ASurrounding left = g.grid[g.ship_location][0];
        ASurrounding right = g.grid[g.ship_location][1];
        if (choice == 'A') {
            doubt++;
            System.out.println(doubt);
        }
    }
}
