/*
Game class
 */

import java.util.Scanner;
public class UserInterface {
    public static void main(String[] args) {
        Controller c = new Controller();
        System.out.println("\nWelcome to Marauders at Sea, an adventure that will test your mettle and heart.\n" +
        "Every pirate needs a good crew, so you'll be traveling with the very best.\n\n" +
                "EURYDICE, the brave captain\n" +
                "CASSEIOPIA 'CAS', the dashing first mate\n" +
                "AMIRA, the clever map maker\n" +
                "AMELIA 'MEELS', the French cook\n" +
                "ISHA 'ISH', the peaceful surgeon\n" +
                "ORLIC, the oddball gunner" +
                "\n\nStay safe out there, sailor. All hands hoay!");

        while (true) {
            char act;

            //takes in user input to determine next action, and then checks if that input is valid
            while (true) {
                System.out.println("\nEnter Action \nM(check map), W(move forward), H(check health), I(check inventory), " +
                        "Q(quit)");
                Scanner input = new Scanner(System.in);
                act = Character.toUpperCase(input.next().charAt(0));
                if (c.isValid(c.moveOps,act)) {
                    break;
                } else {
                    System.out.println("Invalid Action");
                }
            } //if loop ends, user has entered valid action

            String res;
            //forward move
            if (act == 'W') {
                res = c.makeMove();
            }
            //all other actions
            else {
                res = c.respondInput(act);
            }
            //user typed quit - leave game
            if (res.equals("null")) {
                break;
            } else {
                System.out.println(res);
                /*
                  Inventory printing:
                  - displays current resource totals
                  - prompts user to pick something to throw overboard
                 */
                if (act == 'I'){
                    char inInv;
                    while(true){
                        System.out.println("Do you want to throw something overboard? (R) for rope, " +
                                        "(W) for wood, (M) for medicine, or (C) for cancel");
                        Scanner input = new Scanner(System.in);
                        inInv = Character.toUpperCase(input.next().charAt(0));
                        if (c.isValid(c.invOps,inInv)) {
                            break;
                        } else {
                            System.out.println("Invalid Action");
                        }
                    }
                    if (!(inInv == 'C')) {
                        c.callRemoveInventory(inInv);
                        System.out.println("Updated inventory: \n" + c.inv);
                    }
                }
            }
            //prompt user for their decision if they've reached a resource area or an island WITH A QUESTION
            if (res.contains("(Q)")) {
                char choice ;
                while (true) {
                    System.out.println("Choose action A or B");
                    Scanner input = new Scanner(System.in);
                    choice = Character.toUpperCase(input.next().charAt(0));
                    if (choice == 'A' || choice == 'B') {
                        break;
                    } else {
                        System.out.println("Invalid Action");
                    }
                }
                /*
                  Resource area printing:
                  - calls controller to determine if there's room in the inventory
                  - if not, execute removal procedure
                  - prints updated inventory
                 */
                if (res.contains("Oh")) {
                    if (!c.addressResource(choice)) {
                        System.out.println("Damn! We can't squeeze this in. We could throw something " +
                                "overboard if you want... (R) for rope, (W) for wood, (M) for medicine, or (C) to cancel");
                        char i;
                        while (true) {
                            Scanner input = new Scanner(System.in);
                            i = Character.toUpperCase(input.next().charAt(0));
                            if (c.isValid(c.invOps,i)) {
                                break;
                            } else {
                                System.out.println("Invalid choice");
                            }
                        } //if they chose to remove something
                        if (!(i == 'C')) {
                            c.callRemoveInventory(i);
                            c.addressResource(choice);
                            System.out.println("Updated inventory: \n" + c.inv);
                        }
                    }
                    //if inventory was added to with no problem, print updated one.
                    else{
                        System.out.println("Updated inventory: \n" + c.inv);
                    }
                }
                //if they're at an island with a question, call on controller to execute the choice they made (A or B)
                else {
                    System.out.println(c.addressIsland(choice));
                }
             }
            /*
              General island printing:
              - ask user to add island to the map with Y or N
              - if they add it, print updated map
             */
            if(res.contains("(Island)")){
                char inMap;
                while (true) {
                    System.out.println("\nDo you want to add this island to the map? Y or N");
                    Scanner input = new Scanner(System.in);
                    inMap = Character.toUpperCase(input.next().charAt(0));
                    if (inMap == 'Y' || inMap == 'N') {
                        break;
                    } else {
                        System.out.println("Invalid Action");
                    }
                }
                if(inMap == 'Y'){
                    c.addToMap();
                    System.out.println(c.m);
                }
            }
            /*
              Obstacle generation
              - if controller provides something, print it out and prompt user to choose a solution A or B
              - print result
             */
            String obsText = c.generateObstacle();
            if(obsText != null) {
                System.out.println(obsText);
                char inObs;
                while (true) {
                    Scanner input = new Scanner(System.in);
                    inObs = Character.toUpperCase(input.next().charAt(0));
                    if (inObs == 'A' || inObs == 'B') {
                        break;
                    } else {
                        System.out.println("Invalid Action");
                    }
                }
                //execute their choice
                System.out.println(c.addressObstacle(inObs));
            }
            String gameOver = c.gameOver();
            if (!gameOver.equals("false")){
                System.out.println(gameOver);
                break;
            }
        }
            System.out.println("Thank you for playing Marauders at Sea! We hope you enjoyed");
    }
}
