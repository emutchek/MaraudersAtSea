/*
 * A class to represent the cutscenes in the game. Each StoryScene involves textual
 * information about the plot, and some may include a series of y/n questions about
 * how to proceed.
 */
public class StoryScene {
    String text;
    String question;
    String [] options;

    public StoryScene(String text, String q, String[] o) {
        this.text = text;
        this.question = q;
        this.options = o;
    }

    public String toString() {
        if(this.question.contains("?")) {
            return text + "\n" + question + "\nA: " + options[0] + "\nor\nB: " + options[1];
        }
        return text;
    }

}
