/*
 * A class to represent the islands that appear on either side of the ship. On the
 * screen they are printed as small symbols. Each has a little story associated
 * with it. Islands are plottable on the map.
 */
public class Island extends ASurrounding{
    StoryScene story;

    boolean found;
    boolean onMap;

    public Island() {
        symbol = "Ѳ";
    }

    public void setStory(StoryScene s) {
        this.story = s;
    }

    public String toString() {
        return symbol;
    }

    public String displayCards() {
        return story.text;
    }
}
