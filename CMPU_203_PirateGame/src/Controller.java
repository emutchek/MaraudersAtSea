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
    public Boolean respondInput(char act){
        switch(act) {
            case ('M'):
                System.out.println(m);
                return true;
            case ('W'):
                boolean res = g.move();
                return res;
            case ('H'):
                System.out.print(s);
                return true;
            case ('I'):
                System.out.print(inv);
                return true;
            default:
                return false;
        }
    }

}
