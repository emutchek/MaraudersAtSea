public class Controller {
    Library lib = new Library();
    Ship s = new Ship();
    Inventory inv = new Inventory();

    Map m = new Map(lib.getIslands());
    Grid g = new Grid(lib.getIslands());

    int doubt = 0;

    public Controller() {
    }

    public Boolean isValid(char act) {
        return ((act == 'M') || (act == 'W') || (act == 'H') || (act == 'I') || (act == 'Q'));
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

    public void addressResource(char choice) {
        ASurrounding left = g.grid[g.ship_location][0];
        ASurrounding right = g.grid[g.ship_location][1];
        if (choice == 'A') {
            if (left instanceof ResourceArea) {
                inv.updateInventory((ResourceArea) left);
            }
            if (right instanceof ResourceArea) {
                inv.updateInventory((ResourceArea) right);
            }
        }
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
