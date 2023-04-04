package edu.vassar.cmpu203.maraudersatsea.model;
import edu.vassar.cmpu203.maraudersatsea.R;

/*
 * A class to represent the islands that appear on either side of the ship. On the
 * screen they are printed as small symbols. Each has a little story associated
 * with it. Islands are plottable on the map.
 */
public class Island extends ASurrounding{
    StoryScene story;
    boolean found;
    boolean onMap;
    String name;

    public Island(String n) {
        symbol = R.drawable.island;
        onMap = false;
        name = n;
    }

    public String toString(){return name;}

    public void setStory(StoryScene s){
        this.story = s;
    }

    public String displayEnding(char x){
        return story.returnEnding(x);
    }

    public int getSymbol() {return symbol;}

    public String displayCards() {
        return story.toString();
    }
}
