import java.util.ArrayList;
public class Library {

    StoryScene [] all_stories = {
            new StoryScene("//text 0(Island)", "q0", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 1(Island)", "q1(Q)", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 2(Island)", "q2", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 3(Island)", "q3", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 4(Island)", "q4", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 5(Island)", "q5", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 6(Island)", "q6", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 7(Island)", "q7", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 8(Island)", "q8", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 9(Island)", "q9", new String[]{"opA", "opB"}, new String[]{"textA", "textB"})};

    ArrayList<Obstacle> all_obstacles = new ArrayList<Obstacle>();

    public Library() {
        all_obstacles.add(new Obstacle("obs0", new String[]{"opA", "opB"}, new String[]{"use medicine + gain health", "lose health"},0));
        all_obstacles.add(new Obstacle("obs1", new String[]{"opA", "opB"}, new String[]{"use rope + lose health", "use wood + gain health "},1));
        all_obstacles.add(new Obstacle("obs0", new String[]{"opA", "opB"}, new String[]{"use medicine + gain health", "lose health"},0));
        all_obstacles.add(new Obstacle("obs1", new String[]{"opA", "opB"}, new String[]{"use rope + lose health", "use wood + gain health "},1));
        all_obstacles.add(new Obstacle("obs0", new String[]{"opA", "opB"}, new String[]{"use medicine + gain health", "lose health"},0));
        all_obstacles.add(new Obstacle("obs1", new String[]{"opA", "opB"}, new String[]{"use rope + lose health", "use wood + gain health "},1));
    }

    Island [] all_islands = {
            new Island("Island 0"),
            new Island("Island 1"),
            new Island("Island 2"),
            new Island("Island 3"),
            new Island("Island 4"),
            new Island("Island 5"),
            new Island("Island 6"),
            new Island("Island 7"),
            new Island("Island 8"),
            new Island("Island 9"),
    };

    public Island [] getIslands () {
        for (int i = 0; i < 10; i++) {
            all_islands[i].setStory(all_stories[i]);
        }
        return all_islands;
    }

    public StoryScene[] getScenes () {
        return all_stories;
    }



    //ArrayList<ResourceArea> resources = new ArrayList<ResourceArea>();


}
