public class Map {
    Island[] all_islands = new Island[10];
    public Map(StoryScene[] stories) {
        for(int i = 0; i < 10; i++) {
            all_islands[i] = new Island(stories[i]);
        }
    }
}
