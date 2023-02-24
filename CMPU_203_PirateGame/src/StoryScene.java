/*
 * A class to represent the cutscenes in the game. Each StoryScene involves textual
 * information about the plot, and some may include a series of y/n questions about
 * how to proceed.
 */
public class StoryScene {
    String text;

    public StoryScene(String text) {
        this.text = text;
    }
    public void displayCards() {
        System.out.println(this.text);
    }
}
