public class Library {

    StoryScene [] all_stories = {
    new StoryScene("//text 0"),
    new StoryScene("//text 1"),
    new StoryScene("//text 2"),
    new StoryScene("//text 3"),
    new StoryScene("//text 4"),
    new StoryScene("//text 5"),
    new StoryScene("//text 6"),
    new StoryScene("//text 7"),
    new StoryScene("//text 8"),
    new StoryScene("//text 9")};

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
}
