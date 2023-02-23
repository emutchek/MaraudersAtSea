/*
Game class
 */

import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        Grid g = new Grid();
        Ship s = new Ship();
        //Map m = new Map();
        Inventory inv = new Inventory();

        System.out.println("Welcome to PirateGame, a pirate adventure game where you will set off with" +
                " your crew and explore the unknown. \n");
        boolean run = true;
        while(run){
            char act = ' ';
            //takes in user input to determine next action, and then checks if that input is valid
            while (true){
                System.out.println("Enter Action \nM(check map), W(move forward), H(check health), I(check inventory), " +
                        "Q(quit)");
                java.util.Scanner input = new java.util.Scanner(System.in);
                act = input.next().charAt(0);
                if ((act == 'M') || (act == 'W') || (act == 'H') || (act == 'I') || (act == 'Q')){
                    break;
                }
                else {
                    System.out.println("Invalid Action");
                    continue;
                }
            }

            switch(act) {
                case ('M'):
                    System.out.println("m.toString()");
                    break;
                case ('W'):
                    //g.move();
                    break;
                case ('H'):
                    s.toString();
                    break;
                case ('I'):
                    inv.toString();
                    break;
                default:
                    run = false;
                    break;
            }

        }
        System.out.println("Thank you for playing [PirateGame]! We hope you enjoyed");
        //print out game stats, like whether they "won" or not/how much they filled up map
    }

}