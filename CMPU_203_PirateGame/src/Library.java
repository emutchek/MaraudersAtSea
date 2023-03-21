import java.util.ArrayList;
public class Library {
    StoryScene [] all_stories = {
            new StoryScene("\nPirate captain Eurydice receives a letter from her former boss \n" +
            "requesting she take her crew and set off to do a charting mission of the Eastern Islands, \n" +
            "a mysterious far-flung territory guarded by dangerous waters.(Island)",
                    "\n”What do you think, sailor? Do we go?(Q)”\n",
                    new String[]{"“Aye! We’ll rally the crew and give no quarter”", "“We can’t cross the " +
            "Eastern Islands, we’ll be fish food!”\n"},
                    new String[]{"You round up all the crew, restock the ship, " +
            "and set course for the Eastern Islands.", "“Don’t be such a lily-livered wench. We’re going.” " +
            "You round up all the crew, restock the ship, and set course for the Eastern Islands."}),

            new StoryScene("\nThe crew make it to the edge of the territory of the Eastern Islands. \n" +
                    "They stop to explore, but end up stuck in a pit and resorting to petty arguments.(Island)",
                    "N/A", new String[]{"N/A", "N/A"}, new String[]{"N/A", "N/A"}),

            new StoryScene("\nThe crew reach another island, where Meels spots an orange tree and the crew \n" +
                    "gets caught by a local while helping themselves to the fruit.(Island)",
                    "\nDo you think we should heed the man's warning? (Q)\n",
                    new String[]{"We will remain vigilant about our actions, but we must forge ahead.", "Yes, uh, we will keep that in mind."},
                    new String[]{"\nThe man nods gravely and invites you in for a meal.", "\nThe man looks disappointed, nods," +
                            " and walks away without another word."}),

            new StoryScene("\nDuring a particularly bad storm, Cas takes a tumble and gets hurt. \n"+
                    "Tensions are high and Ish has to put their surgery skills to good use.(Island) ",
                    "N/A", new String[]{"N/A", "N/A"}, new String[]{"N/A", "N/A"}),

            new StoryScene("\nCas and Amira have a falling-out and come to better understand each " +
                    "other.(Island)", "N/A", new String[]{"N/A", "N/A"}, new String[]{"N/A", "N/A"}),

            new StoryScene("\nMeels and Eurydice had gone off to explore another island, and come back with \n" +
                    "signs of other foreign explorers who had come before them, sponsored by a company called\n" +
                    "Eastern Helion Expansion (EHE). Cas knows EHE to be an antagonistic group who've recently exploded \n" +
                    "with unexplained profits. (Island)",
                    "\nDo you stick around here to comb for more evidence or press on in order to meet the deadline?(Q)",
                    new String[]{"We keep going - we can't lose sight of why we're here",
                    "Let's do some research, who knows what we'll find?"},
                    new String[]{"The ship sails on",
                            "While deciphering old ship manifests, Amira realizes that the owners of EHE \n" +
                            "previously operated under a different name and did business with Eurydice's mentor."}),

            new StoryScene("\nIsh and Orlic set off on a hike to search for more food.(Island)", "N/A",
                    new String[]{"N/A","N/A"}, new String[]{"N/A","N/A"}),

            new StoryScene ("\nThe crew encounters a pair of natives in the middle of fishing who \n" +
                    "agree to show them the area. They explore a large cave system and make camp together ashore for the \n" +
                    "night. Amira chatters enthusiastically with the fishers about their culture, and they patiently \n" +
                    "describe a secret text they carry with them with information on a sacred grove of trees with \n" +
                    "magical properties. (Island)", "Night falls and everyone falls asleep. You see this sacred text tucked \n" +
                    "in the local woman's satchel. Do you take a peek? (Q)",
                    new String[]{"I'll look quickly - no one will know.","It's sacred, I should leave it alone."},
                    new String[]{"\nYou find a simple map sketched in the first few pages, marking a location that seems \n" +
                            "to be just one island north of here.","\nYou pass a peaceful night."}),

            new StoryScene ("\nFollowing the map, the crew drops anchor besides an island \n" +
                    "densely packed with strange-looking trees. Orlic, Eurydice and Amira take out a boat to explore \n" +
                    "further, and Amira notices traces of a thick brown substance that resembles an incredibly rare fuel \n" +
                    "her country has experimented with to make cutting-edge technology.(Island)", "Do you fill a vial with \n" +
                    "the tree sap or head back to the ship?(Q)",
                    new String[]{"Yes, we need a sample to prove what we've seen.", "No, best leave it be."},
                    new String[]{"\nYou safely stow the substance in the ship hold.","\nYou head back to the ship and sail away."}),

            new StoryScene ("\nCas and Amira bond while exploring another island. (Island)",
                    "", new String[]{"",""}, new String[]{"",""}),

            new StoryScene ("\nEurydice receives a letter via bird from her mentor. It demands that \n" +
                    "the crew send the map immediately, being sure to highlight any potential obstacles to further \n" +
                    "exploration and expansion into the area. It's clear that plans are about to be underway.(Island)",
                    "\nDo you send the map?(Q)",
                    new String[]{"Yes, time is running out!","No, I don't think it's a good idea"},
                    new String[]{"\nEurydice carefully packages up all of your notes on everything you've seen, sending " +
                            "the bird back into the horizon.","\nThe crew readies their things to start sailing home, the map" +
                            "locked safely into the ship vault."}),

            new StoryScene ("\nCongratulations! The crew has made it home safely. \nEPILOGUE\n\nSix months later, " +
                    "Eurydice finally relents to Amira's requests to put together an expedition and visit their friends \n" +
                    "in the Eastern Islands. They stock up plenty of fruit this time and enjoy calm waters on the voyage.\n" +
                    " When they arrive, they learn what has happened with EHE. \nTHE END",
                    "", new String[]{"",""}, new String[]{"",""}),
    } ;

    StoryScene[] all_secstories = {
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            new StoryScene ("\nThe next morning, the locals invite the crew to attend a \n" +
                    "nearby festival with them. Everyone dresses in their finest and joins milling crowds for a night \n" +
                    "of music and dance. They get to chatting with some of the inhabitants, who mention that there \n" +
                    "are hostile forces planning something bad for the Eastern Islands.(Island)",
                    "Do you warn them about what you know?(Q)", new String[]{"We'll tell them everything we know.",
                    "Better keep it to ourselves - we don't know how they'll react."}, new String[]{"The locals thank " +
                    "you for the information and urge you to keep in touch","After the party you head back to the ship."}),
            null,
            null,
            new StoryScene ("\nCongratulations! The crew has made it home safely. \nEPILOGUE\n\nSix months later, " +
                    "Eurydice finally relents to Amira's requests to put together an expedition and visit their friends \n" +
                    "in the Eastern Islands. They stock up plenty of fruit this time and enjoy calm waters on the voyage. \n" +
                    " The inhabitants of the islands are glad to see them, and share news about EHE. The crew is confident" +
                    "that they did the right thing. \nTHE END",
                    "", new String[]{"",""}, new String[]{"",""}),
    };

    ArrayList<Obstacle> all_obstacles = new ArrayList<Obstacle>();

    public Library() {
        all_obstacles.add(
                new Obstacle("-----☠ PLAGUE ALERT ☠-----\n " +
                        "Meels woke up with a fever this morning, which wasn't that concerning, until her finger turned \n" +
                        "purple and she erupted in boils. We must have incurred the wrath of an angry spirit... or \n" +
                        "maybe it was the brownish drinking water that Amira forgot to change.\nWhat do you do?",
                new String[]{"People get sick all the time! Let's play limbo on the deck",
                        "Give Meels a vial of medicine and keep her quarantined"},
                new String[]{"Now everyone's sick and there's no one to get fresh water! (-10 HEALTH)",
                        "Good call - she's feeling much better."},
                        0));
        all_obstacles.add(
                new Obstacle("----- SHIP MALFUNCTION -----\nUm... is that big wooden pole supposed to be in two pieces?",
                        new String[]{"Orlic comes up with a spool of rope and wooden spoon and offers to help",
                                "We better use some of our wood to construct a new mast here on the deck"},
                        new String[]{"Orlic thought you wanted her to build a swing - this ship won't be sailing anytime soon (-10 HEALTH)",
                                "It looks like that did the trick... for now"},1));
        all_obstacles.add(
                new Obstacle("----- IS OUR WOODEN SHIP ON FIRE??? -----\n" +
                        "Isha's foot is caught and she's stuck by the flames, but the inventory is about to catch fire!",
                        new String[]{"Ish will be fine, save the booty!",
                                "Run and help her!"},
                        new String[]{"Isha's ankle sustains minor burns, so she'll be on bed rest for awhile (-10 HEALTH)",
                                "Phew, we all made it! Looks like a few things got a little, uh... crispy"},2));
        all_obstacles.add(
                new Obstacle("----- (WO)MAN OVERBOARD -----\n" +
                        "Meels used the plank as a runway again and fell right off the edge!",
                        new String[]{"We'll lower Cas down by her ankles to snatch her up",
                                "Lower some rope over the edge for her to grab on"},
                        new String[]{"Cas has so many weapons strapped to her that she falls in too, and both get pneumonia damn (-10 HEALTH)",
                                "She clambers back up gratefully"},2));
        all_obstacles.add(
                new Obstacle("----- SOUND OF SIRENS -----\n" +
                        "As the ship enters a rocky area, a pair of beautiful sirens on a cliff bewitch half the crew",
                        new String[]{"Avast ye and steer hard to port!",
                                "Grab your fellow pirates and tie them to the masts before they jump over"},
                        new String[]{"Ah son of a biscuit eater, we hit a rock! (-10 HEALTH)",
                                "You save all your hearties and the ship sails on"},3));
    }

    Island [] all_islands = {
            new Island("\nThe Isle of Graves"),
            new Island("\nThe Pitt"),
            new Island("\nOrange Forests"),
            new Island("\nRocky Rapids"),
            new Island("\nHigh Peaks"),
            new Island("\nDunes"),
            new Island("\nGrotto"),
            new Island("\nCaves"),
            new Island("\nThe Grove/The Meeting Place"),
            new Island("\nBeach"),
            new Island("\nThe Border"),
            new Island("\nEnding"),
    };

    /**
     * Sets the StoryScene field in each island object
     * @return edited list of islands
     */
    public Island [] getIslands () {
        for (int i = 0; i < 12; i++) {
            if ((i == 8) || (i==11)){
                all_islands[i].setStory(all_secstories[i]);
            }
            else {
                all_islands[i].setStory(all_stories[i]);
            }
        }
        return all_islands;
    }

    public StoryScene[] getScenes () {
        return all_stories;
    }



    //ArrayList<ResourceArea> resources = new ArrayList<ResourceArea>();


}
