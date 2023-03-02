public class Library {

    StoryScene [] all_stories = {
            new StoryScene("//text 0", "q0", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 1", "q1?'", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 2", "q2", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 3", "q3", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 4", "q4", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 5", "q5", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 6", "q6", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 7", "q7", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 8", "q8", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 9", "q9", new String[]{"opA", "opB"}, new String[]{"textA", "textB"})};

    Island [] all_islands = {
            new Island(),
            new Island(),
            new Island(),
            new Island(),
            new Island(),
            new Island(),
            new Island(),
            new Island(),
            new Island(),
            new Island(),
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
