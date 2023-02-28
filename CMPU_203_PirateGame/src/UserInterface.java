/*
Game class
 */

import java.util.Scanner;
public class UserInterface {
    public static void main(String[] args) {
        Controller c = new Controller();
        System.out.println("Welcome to PirateGame, a pirate adventure game where you will set off with" +
                " your crew and explore the unknown. \n");

        while(true){
            char act;

            //takes in user input to determine next action, and then checks if that input is valid
            while (true){
                System.out.println("\nEnter Action \nM(check map), W(move forward), H(check health), I(check inventory), " +
                        "Q(quit)");
                Scanner input = new Scanner(System.in);
                act = input.next().charAt(0);
                if (c.isValid(act)){
                    break;
                }
                else {
                    System.out.println("Invalid Action");
                }
            } //if loop ends, user has entered valid action
            String res = c.respondInput(act);
            if (res.equals("null")){
                break; //user typed quit or reached end of map - leave game
            }
            else{
                System.out.println(res);
            }
        }
        System.out.println("Thank you for playing [PirateGame]! We hope you enjoyed");
        //print out game stats, like whether they "won" or not/how much they filled up map
    }

}