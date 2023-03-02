/*
Game class
 */

import java.util.Scanner;
public class UserInterface {
    public static void main(String[] args) {
        Controller c = new Controller();
        System.out.println("Welcome to PirateGame, a pirate adventure game where you will set off with" +
                " your crew and explore the unknown. \n");

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
            } else {
                res = c.respondInput(act);
            }

            if (res.equals("null")) {
                break; //user typed quit or reached end of map - leave game
            } else {
                System.out.println(res);
            }
            //execute story or resource area interaction
            if (res.contains("?'")) {
                char choice = ' ';
                while (true) {
                    System.out.println("\nChoose action A or B");
                    Scanner input = new Scanner(System.in);
                    choice = input.next().charAt(0);
                    if (choice == 'A' || choice == 'B') {
                        break;
                    } else {
                        System.out.println("Invalid Action");
                    }
                } //they've given valid A or B

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
                        }
                    }


                }
                //if they're at an island
                else {
                    c.addressIsland(choice);
                }
             }
        }
            System.out.println("Thank you for playing [PirateGame]! We hope you enjoyed");
            //print out game stats, like whether they "won" or not/how much they filled up map
    }
}
