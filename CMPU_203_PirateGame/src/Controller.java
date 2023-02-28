public class Controller {
    Library lib = new Library();
    Ship s = new Ship();
    Inventory inv = new Inventory();

    Map m = new Map(lib.getIslands());
    Grid g = new Grid(lib.getIslands());

    public Controller() {}

    public Boolean isValid(char act){
        return ((act == 'M') || (act == 'W') || (act == 'H') || (act == 'I') || (act == 'Q'));
    }
    public String respondInput(char act){
        switch(act) {
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

    public String makeMove(){
        if (!g.move()){
            return "null";
        }
        ASurrounding left = g.grid[g.ship_location][0];
        ASurrounding right = g.grid[g.ship_location][1];
        String ret = g.toString();
        //check if the ship is next to an island
        if (left instanceof Island){
            ret += ((Island) left).displayCards();
        }
        else if(right instanceof Island){
            ret +=((Island) right).displayCards();
        }
        //check if ship is next to a resource area
        else if (left instanceof ResourceArea){
            ret +=((ResourceArea) left).displayCards();
        }
        else if(right instanceof ResourceArea){
            ret +=((ResourceArea) right).displayCards();
        }

        return ret;
    }


}
