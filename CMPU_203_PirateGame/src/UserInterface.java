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
                act = input.next().charAt(0);
                if (c.isValid(c.moveOps,act)) {
                    break;
                } else {
                    System.out.println("Invalid Action");
                }
            } //if loop ends, user has entered valid action

            String res = "";
            if (act == 'W') {
                //do all the associated move stuff
                res = c.makeMove();
            }
            else {
                res = c.respondInput(act);
            }

            if (res.equals("null")) {
                break; //user typed quit - leave game
            } else {
                System.out.println(res);
                if (act == 'I'){
                    char inInv;
                    while(true){
                        System.out.println("Do you want to remove something from inventory? (R) for rope, " +
                                        "(W) for wood, (M) for medicine, or (C) for cancel");
                        Scanner input = new Scanner(System.in);
                        inInv = input.next().charAt(0);
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
            //if they've reached a resource area or an island WITH A QUESTION
            if (res.contains("(Q)")) {
                char choice = ' ';
                while (true) {
                    System.out.println("Choose action A or B");
                    Scanner input = new Scanner(System.in);
                    choice = input.next().charAt(0);
                    if (choice == 'A' || choice == 'B') {
                        break;
                    } else {
                        System.out.println("Invalid Action");
                    }
                }
                //if they're at a resource
                if (res.contains("Oh")) {
                    //updates inventory if there's space, or enters if statement if there isn't
                    if (!c.addressResource(choice)) {
                        System.out.println("Damn! Looks like we can't squeeze this in. We could throw something " +
                                "overboard if you want... (R) for rope, (W) for wood, (M) for medicine, or (C) to cancel");
                        char i;
                        while (true) {
                            Scanner input = new Scanner(System.in);
                            i = input.next().charAt(0);
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
                //if they're at an island with a question
                else {
                    System.out.println(c.addressIsland(choice));
                }
             }
            //for all islands, even if there's no question, ask the user if they want to add to map
            if(res.contains("(Island)")){
                char inMap = ' ';
                while (true) {
                    System.out.println("\nDo you want to add this island to the map? Y or N");
                    Scanner input = new Scanner(System.in);
                    inMap = input.next().charAt(0);
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
            String obsText = c.generateObstacle();
            if(obsText != null) {
                System.out.println(obsText);
                char inObs = ' ';
                while (true) {
                    Scanner input = new Scanner(System.in);
                    inObs = input.next().charAt(0);
                    if (inObs == 'A' || inObs == 'B') {
                        break;
                    } else {
                        System.out.println("Invalid Action");
                    }
                }
                //execute their choice
                System.out.println(c.addressObstacle(inObs));
            }
            if (c.gameOver()){
                break;
            }
        }
            System.out.println("Thank you for playing [PirateGame]! We hope you enjoyed");
            //print out game stats, like whether they "won" or not/how much they filled up map
    }
}
