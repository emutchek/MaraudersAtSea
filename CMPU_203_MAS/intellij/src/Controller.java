import java.util.ArrayList;
public class Controller {
    Library lib = new Library();
    Ship s = new Ship();
    Inventory inv = new Inventory();

    Map m = new Map(lib.all_islands);
    Grid g = new Grid(lib.all_islands);

    Obstacle tempObs = new Obstacle();

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
        lib.setIslands();
    }

    /**
     * @param options list of valid user inputs
     * @param c user input
     * @return whether user input is valid
     */
    public Boolean isValid(ArrayList<String> options, char c) {
        return options.contains(String.valueOf(c));
    }

    /**
     * Executes map, health, inventory, and quit options
     * @param act user's action
     * @return text to be displayed
     */
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

    public void adjustStories() {
        if(g.islandsMet == 7){
            if(doubt >= 2){
                //change The Grove story text to be the Meeting Place text
                g.all_islands[8].story = lib.all_secstories[8];
            }
        }
        if(g.islandsMet == 9) {
            if(doubt < 2) {
                //remove the question from you've got mail
                g.all_islands[10].story.question = "N/A";
            }
        }
    }

    public String makeMove() {
        this.adjustStories();
        return g.executeMove();
    }

    /**
     * Adds any resource that the ship is adjacent to the inventory
     * @param choice user's input, A or B
     * @return whether inventory is full
     */
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

    /**
     * Increments doubt meter if a harmful choice was made, then gives the UI the appropriate result
     * @param choice user's input, A or B
     * @return the story text associated with that decision
     */
    public String addressIsland(char choice) {
       if (choice == 'A') {
            doubt++;
           //if they choose not to send in the map, they get shown the good ending regardless of their doubt
           if(g.islandsMet == 11) {
               g.all_islands[11].story = lib.all_secstories[11];
           }
        }
        return g.all_islands[g.islandsMet-1].displayEnding(choice);
    }

    public void addToMap() {
        m.addIsland(g.islandsMet-1);
    }

    /**
     * Chooses random obstacle from the list, 10% of the time
     * @return text of an obstacle, or null
     */
    public String generateObstacle() {
        if(Math.random() <= 0.1) {
            int randIndex = (int)(Math.random() * 5);
            tempObs = lib.all_obstacles.get(randIndex);
            //lib.all_obstacles.remove(tempObs);
            return tempObs.toString();
        }
        return null;
    }

    /**
     * Carries out effects of poor decisions by decrementing ship health
     */
    public char performSolutionA(int x) {
        switch (x) {
            //(wo)man overboard
            case 4:
                break;
            case 5:
                if(inv.medicine == 0) {
                    inv.removeInventory('M');
                    break;
                }
                else {performSolutionB(x);}
                break;
            default:
                s.updateHealth(-25);
            break;
        }
        return 'A';
    }

    /**
     * Carries out effects of when user chooses to address obstacle by consuming resources
     * If they don't have the resources required, it executes the other option automatically
     * @param x index of which obstacle the user is facing
     */
    public char performSolutionB (int x) {
        switch (x) {
            case 0:
            case 1:
                if(inv.medicine == 0) {return performSolutionA(x);}
                else {
                    inv.removeInventory('M');
                    s.updateHealth(25);
                }
                break;

            case 2:
            case 3:
                if(inv.wood < 10) {return performSolutionA(x);}
                else {
                    inv.removeInventory('W');
                }
                break;

            case 4:
                if(inv.rope == 0) {return performSolutionA(x);}
                else {
                    inv.removeInventory('R');
                }
                break;
            case 6:
                if(inv.medicine == 0 || inv.rope == 0 || inv.wood == 0) {return performSolutionA(x);}
                else {
                    inv.removeInventory('R');
                    inv.removeInventory('W');
                    inv.removeInventory('M');
                }
            break;
            //cases where B was wrong - 4 (woman overboard), 5 (sound of sirens)
            default:
                s.updateHealth(-25);
                break;
        }
        return 'B';
    }

    /**
     * Takes in whichever solution the user wants to do and executes it
     * @param c the user's desired solution, A or B
     * @return the text to be displayed based on which choice the user made
     */
    public String addressObstacle(char c) {
        if(c == 'A') {
            c = performSolutionA(tempObs.code);
        }
        else {
            c = performSolutionB(tempObs.code);
        }
        return tempObs.returnObsEnding(c);
    }

    public String gameOver(){
        String ret = "false";
        if (s.health <= 0) {
            ret = "Your ship has taken too much damage. " +
                    "You and your crew have taken residence in Davy Jones' locker. :(";
        }
        if (g.islandsMet >= 12) {
            ret = "";
        }
        return ret;
    }
}
