import java.util.ArrayList;
public class Library {

    StoryScene [] all_stories = {
            new StoryScene("\nOne afternoon, on a tiny island filled with the boldest, drunkest and strongest pirates \n" +
                    "in all the land, a young woman chews on the end of her quill. She frowns at the piece of parchment \n" +
                    "before her, skimming the words again. “Dear Eurydice…. Urgent favor to request… powerful new client \n" +
                    "who’s in a hurry… Know we can count on you given our past… A thorough depiction of the Eastern islands \n" +
                    "and any creatures who may inhabit them… Send the map back to this address in no less than two months’ \n" +
                    "time… Your old friend.” It was unsigned, but she recognized the handwriting of her old mentor. There \n" +
                    "was no telling what shifty client he was working with this time.You lean against the counter, twirling \n" +
                    "a knife absentmindedly. You’ve heard of this mysterious mentor, and the shady people he worked with. \n" +
                    "But the whole crew knows that she can never let things go. She turns to you. (Island)",
                    "\n”What do you think, sailor? Do we go?(Q)”\n",
                    new String[]{"“Aye! We’ll rally the crew and give no quarter”", "“We can’t cross the Eastern Islands, we’ll be fish food!”\n"},
                    new String[]{"\nA few blocks down the street, a tearful redheaded girl runs out of the tavern. Cassiopeia \n" +
                            "pops her head through the doorway, “It’s not you, it’s me!” she calls helpfully. Some of \n" +
                            "the women in the street cast subtle looks at Cas’ tumbling black curls, and she winks back \n" +
                            "at them. “Cas!” Eurydice stomps over. “Get the others, we’re leaving.” “What, now? Isha’s \n" +
                            "at the market, and Amira’s waiting for a letter, and I haven’t even seen Orlic since she \n" +
                            "stole that man’s tooth.” Eurydice winced. “Just do your best. I’m going to have a drink. \n" +
                            "Anchors up by sunrise.”\n", "“Don’t be such a lily-livered wench. We’re going.” \n\n" +
                            "A few blocks down the street, a tearful redheaded girl runs out of the tavern. Cassiopeia \n" +
                            "pops her head through the doorway, “It’s not you, it’s me!” she calls helpfully. Some of \n" +
                            "the women in the street cast subtle looks at Cas’ tumbling black curls, and she winks back \n" +
                            "at them. “Cas!” Eurydice stomps over. “Get the others, we’re leaving.” “What, now? Isha’s \n" +
                            "at the market, and Amira’s waiting for a letter, and I haven’t even seen Orlic since she \n" +
                            "stole that man’s tooth.” Eurydice winced. “Just do your best. I’m going to have a drink. \n" +
                            "Anchors up by sunrise.”\n"}),
            new StoryScene("\nAfter a week of sailing, the crew reached the first unexplored island. Everyone was \n" +
                    "so sick of Meels’ flute playing that they all volunteered to take the dinghy and start trekking \n" +
                    "across the beach. Amira, the ship cartographer, had been so focused on her calculations that she \n" +
                    "accidentally stepped on a booby trap, dumping them all in a steep ditch. “Cas was supposed to keep \n" +
                    "lookout!” “Yeah, behind us. Forward’s all up to you, love.” Isha holds their arms out between them. \n" +
                    "Meels starts whacking a sword against the rock. “Hey! That’s mine!” Eurydice protests, yanking \n" +
                    "Meels’ blonde ponytail with muddy fingers. Isha facepalms as the crew abandons their escape effort \n" +
                    "in favor of slinging mud at each other. Cas tackles Eurydice (who is quite a bit taller) and grins \n" +
                    "proudly, still effortlessly dashing in a heap on the floor. Amira catches her gaze through the \n" +
                    "mayhem and blushes. You survey the scene when something catches your eye. Across the cave, Orlic - \n" +
                    "the talented gunner with a head full of curls and wild eyes - is somehow… magically holding herself \n" +
                    "up on the cave wall, her odd makeshift bracelet clicking against the rock. It falls quiet, everyone \n" +
                    "wearing the same shocked expression. “Do you think we could use these handholds to get out?” Orlic \n" +
                    "asks seriously.(Island)",
                    "q1(Q)", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
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
        all_obstacles.add(new Obstacle("obs0", new String[]{"opA", "opB"}, new String[]{"", ""},0));
        all_obstacles.add(new Obstacle("obs1", new String[]{"opA", "opB"}, new String[]{"", ""},1));
        all_obstacles.add(new Obstacle("obs0", new String[]{"opA", "opB"}, new String[]{"", ""},0));
        all_obstacles.add(new Obstacle("obs1", new String[]{"opA", "opB"}, new String[]{"", ""},1));
        all_obstacles.add(new Obstacle("obs0", new String[]{"opA", "opB"}, new String[]{"", ""},0));
        all_obstacles.add(new Obstacle("obs1", new String[]{"opA", "opB"}, new String[]{"", ""},1));
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
