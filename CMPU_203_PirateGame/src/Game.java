/*
Game class
 */

import java.util.Scanner;
public class Game {
    public static void main(String[] args) {

        Ship s = new Ship();
        Inventory inv = new Inventory();

        StoryScene [] all_stories = new StoryScene [10];
        all_stories[0] = new StoryScene("//text 1");
        all_stories[1] = new StoryScene("//text 2");
        all_stories[2] = new StoryScene("//text 3");
        all_stories[3] = new StoryScene("//text 4");
        all_stories[4] = new StoryScene("//text 5");
        all_stories[5] = new StoryScene("//text 6");
        all_stories[6] = new StoryScene("//text 7");
        all_stories[7] = new StoryScene("//text 8");
        all_stories[8] = new StoryScene("//text 9");
        all_stories[9] = new StoryScene("//text 10");

        Map m = new Map(all_stories);
        Grid g = new Grid(m.all_islands);
        System.out.println("Welcome to PirateGame, a pirate adventure game where you will set off with" +
                " your crew and explore the unknown. \n");

        boolean run = true;
        while(run){
            char act = ' ';
            //takes in user input to determine next action, and then checks if that input is valid
            while (true){
                System.out.println("\nEnter Action \nM(check map), W(move forward), H(check health), I(check inventory), " +
                        "Q(quit)");
                Scanner input = new Scanner(System.in);
                act = input.next().charAt(0);
                if ((act == 'M') || (act == 'W') || (act == 'H') || (act == 'I') || (act == 'Q')){
                    break;
                }
                else {
                    System.out.println("Invalid Action");
                }
            }

            switch(act) {
                case ('M'):
                    System.out.println("m.toString()");
                    break;
                case ('W'):
                    g.move();
                    //System.out.print("after:\n" + g);
                    break;
                case ('H'):
                    System.out.print(s);
                    break;
                case ('I'):
                    System.out.print(inv);
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