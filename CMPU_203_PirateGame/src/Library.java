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
            new StoryScene("After a few more days of sailing, the crew docks at the next island they find, sore and\n" +
                    " starving for something other than the nearing-stale rations on the ship. Meels scanned the \n" +
                    "surroundings hopefully as they walked, grumbling about “not having had a proper meal for days”. \n" +
                    "Ish rolled their eyes, reminding Meels that she had just had an exorbitant omelete this morning, \n" +
                    "using up almost half of their protein stores in the process. Meels shushed them, mouth agape, \n" +
                    "pointing in the distance at a beautiful cluster of orange trees that appeared over the horizon. \n" +
                    "Eurydice jumped up and thumped Meels’ shoulder excitedly. “We need to head to those trees ASAP. \n" +
                    "I feel like I’ve been eating the same cardboard for weeks.” She looked back at Amira and Cas, who \n" +
                    "were walking a bit behind and talking quietly, heads bent together, and said loudly, “I don’t know \n" +
                    "what you two are doing back there but it needs to stop. Cas- set course. To the oranges!” Cas stuck \n" +
                    " her tongue out at her in response and the gang started the journey to trees... \n" +
                    "The first thing the strangely dressed man said to them is a simple question- “who are you?” Meels \n" +
                    "stared at him, left arm and bag full with the bright fruit with her long blonde hair swinging behind\n" +
                    " her, in the process of plucking another orange off the tree with her right. Orlic stood and fixed \n" +
                    "him with a stare. “I think the real question is, who are you.” She nodded like she had said \n" +
                    "something very wise, and Eurydice shook her head and stepped forward. “Ignore her. Look–whoever you\n" +
                    " are– I know this looks bad. But in our defense! The place is abandoned, and also we were hungry, \n" +
                    "so…” He shook his head. “The Eastern Islands are not abandoned. We are here, and always have been. \n" +
                    "We don’t like foreigners.” He looked at Meels. “Please let the orange go.” There was a silence. \n" +
                    "Amira pushed her glasses up and looked around at the others before speaking up. “We are foreigners, \n" +
                    "but we mean no harm to you and your people. We are here on a purely intellectual mission. What’s \n" +
                    "your name?” The man studied her, seeming to sense her sincerity but not seeming convinced. \n" +
                    "“Unfortunately, there is no such thing. I am NA. I advise you to leave. The knowledge you’re seeking\n" +
                    " comes with a price. However, if you must stay, come, we will feed you.“ (Island)",
                    "“What is your choice?“(Q)",
                    new String[]{"We understand, but we'd still like to stay", "Nothing gets between me and my coffer - " +
                            "we don't need your food anyway"},
                    new String[]{"The man nods gravely. “Very well“", "The man shoots you an unamused look and slips away.\n"}),
            new StoryScene("It was becoming clear that the crew wasn’t in a cluster of islands, but an expansive \n" +
                    "network that stretched beyond the eye could see. You’ve caught glimpses of weird boats that seem \n" +
                    "like some sort of watercraft, and you’re unsure just how many people may live here. One evening, a \n" +
                    "terrible storm rolls in that sends furious waves through the briny deep. Rain pounds down on the \n" +
                    "deck, barrels careen dangerously, and a section of loose rigging is slowly pulling down the foresail. \n" +
                    "Eurydice and Cas are climbing the ratlines, trying to redo the knots. All of a sudden, a hunk of \n" +
                    "wood from somewhere above snaps off with a crack and sails down. Cas shoves Eurydice aside, yelling \n" +
                    "as the debris buries itself in her arm. Her other hand grasps uselessly for a hold before she falls. \n" +
                    "Belowdecks, Ish (the resident surgeon) hastily sweeps papers off a desk as the bleeding patient is \n" +
                    "deposited before them. Their tattoos seem to dance in the candlelight, and they tuck their long \n" +
                    "braids behind their shoulder, somehow projecting stillness and calm. Amira hovers nervously as Ish \n" +
                    "splashes rum across Cas’s arm. “M’okay,” Cas mumbles deliriously. “Your arm is half detached!” \n" +
                    "Amira cried. “‘ve had worse,” she insisted. Isha and Amira exchanged looks - Cas was from Helion, \n" +
                    "the powerful sun empire, and had lived a very comfortable life before running away to take up \n" +
                    "privateering. She didn’t have the jagged scars and crooked teeth that Eurydice and Isha and Orlic \n" +
                    "sported (no one actually knew where Orlic was from). Nevertheless, Cas got through her surgery with \n" +
                    "stubborn bravado, and a few hours later she was left to sleep off the damage. The pirate snored \n" +
                    "peacefully on the table, arm wrapped in an old fencing uniform of Meels’. \n(Island)"
                    , "q3", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 4(Island)", "q4", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 5(Island)", "q5", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 6(Island)", "q6", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 7(Island)", "q7", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 8(Island)", "q8", new String[]{"opA", "opB"}, new String[]{"textA", "textB"}),
            new StoryScene("//text 9(Island)", "q9", new String[]{"opA", "opB"}, new String[]{"textA", "textB"})};

    ArrayList<Obstacle> all_obstacles = new ArrayList<Obstacle>();

    public Library() {
        all_obstacles.add(
                new Obstacle("-----☠ PLAGUE ALERT ☠-----\n Meels woke up with a fever this morning, which \n" +
                "wasn't that concerning, until her finger turned purple and she erupted in boils. They must have incurred \n" +
                "the wrath of an angry spirit... or maybe it was the brownish drinking water that Amira forgot to change.\n" +
                "What do you do?",
                new String[]{"Give Meels a vial of medicine and keep her quarantined",
                        "People get sick all the time! Let's play limbo on the deck"},
                new String[]{"Good call - she's feeling much better.",
                        "Now everyone's sick and there's no one to get fresh water! (-10 HEALTH)"},
                        0));
        all_obstacles.add(
                new Obstacle("----- SHIP MALFUNCTION -----\nUm... is that big wooden pole supposed to be in two pieces?",
                        new String[]{"Orlic comes up with a spool of rope and wooden spoon and offers to help",
                                "We better use some of our wood to construct a new mast here on the deck"},
                        new String[]{"Orlic thought you wanted her to build a swing - this ship won't be sailing anytime soon (-10 HEALTH)",
                                "It looks like that did the trick... for now"},1));
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
