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
            case ('W'):
                String res = g.move();
                if(res.equals("end")) {return "null";}
                else return res;
            case ('H'):
                return s.toString();
            case ('I'):
                return inv.toString();
            default:
                return "null";
        }
    }
}
