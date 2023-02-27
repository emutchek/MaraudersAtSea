public class Controller {
    Library lib = new Library();
    Ship s = new Ship();
    Inventory inv = new Inventory();

    Map m = new Map(lib.getScenes());
    Grid g = new Grid(m.all_islands);

    public Controller() {}

    public Boolean isValid(char act){
        return ((act == 'M') || (act == 'W') || (act == 'H') || (act == 'I') || (act == 'Q'));
    }
    public Boolean respondInput(char act){
        switch(act) {
            case ('M'):
                System.out.println("m.toString()");
                return true;
            case ('W'):
                return g.move();
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
