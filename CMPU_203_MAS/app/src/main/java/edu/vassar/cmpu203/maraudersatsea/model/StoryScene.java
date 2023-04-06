package edu.vassar.cmpu203.maraudersatsea.model;

/*
 * A class to represent the cutscenes in the game. Each StoryScene involves textual
 * information about the plot, and some may include a series of y/n questions about
 * how to proceed.
 */
public class StoryScene {
    String text1;
    String text2;
    String question;
    public String [] options;
    public String [] endings;

    public StoryScene(String text1, String text2, String q, String[] o, String[] e) {
        this.text1 = text1;
        this.text2 = text2;
        this.question = q;
        this.options = o;
        this.endings = e;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public String getQuestion() {
        return question;
    }

    public String returnEnding(char x){
        if (x=='A'){
            return this.endings[0];
        }
        else{
            return this.endings[1];

        }
    }
}
