/*
 * A class to represent the islands that appear on either side of the ship. On the
 * screen they are printed as small symbols. Each has a little story associated
 * with it. Islands are plottable on the map.
 */
public class Island extends ASurrounding{
    StoryScene story;
    String symbol = "Ѳ";
    String descr; //how does it appear on the map? ex "Old Cave"
    boolean found;
    boolean onMap;

    public void setStory(StoryScene s) {
        this.story = s;
    }

    public String toString() {
        return symbol;
    }


}
