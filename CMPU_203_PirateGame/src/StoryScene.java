/*
 * A class to represent the cutscenes in the game. Each StoryScene involves textual
 * information about the plot, and some may include a series of y/n questions about
 * how to proceed.
 */
public class StoryScene {
    String text;
    String question;
    String [] options;
    String [] endings;

    public StoryScene(String text, String q, String[] o, String[] e) {
        this.text = text;
        this.question = q;
        this.options = o;
        this.endings = e;
    }

    public String toString() {
        if(this.question.contains("?")) {
            return text + "\n" + question + "\nA: " + options[0] + "\nor\nB: " + options[1];
        }
        return text;
    }

}
