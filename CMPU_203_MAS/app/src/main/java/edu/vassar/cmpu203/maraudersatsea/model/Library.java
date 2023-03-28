package edu.vassar.cmpu203.maraudersatsea.model;

import java.util.ArrayList;
public class Library {
    StoryScene [] all_stories = {
            new StoryScene("\nPirate captain Eurydice receives a letter from her former boss \n" +
                    "requesting she take her crew and set off to do a charting mission of the Eastern Islands, \n" +
                    "a mysterious far-flung territory guarded by dangerous waters.",
                    "\n”What do you think, sailor? Do we go?(Q)”\n",
                    new String[]{"“We can’t cross the Eastern Islands, we’ll be fish food!”",
                            "“Aye! We’ll rally the crew and give no quarter”"},
                    new String[]{"“Don’t be such a lily-livered wench. We’re going.”\n" +
                            "You round up all the crew, restock the ship, and set course for the Eastern Islands.",
                            "You round up all the crew, restock the ship, and set course for the Eastern Islands."}),

            new StoryScene("\nThe crew make it to the edge of the territory of the Eastern Islands. \n" +
                    "They stop to explore, but end up stuck in a pit and resorting to petty arguments.(Island)",
                    "N/A", new String[]{"N/A", "N/A"}, new String[]{"N/A", "N/A"}),

            new StoryScene("\nThe crew reach another island, where Meels spots an orange tree and the crew \n" +
                    "gets caught by a local while helping themselves to the fruit. \n " +
                    "He asks what you're doing here. You explain your mission to make a map, and he \n" +
                    "warns you that no good will come of it and you should leave. (Island)",
                    "\nWhat do you say? (Q)\n",
                    new String[]{"We will remain vigilant about our actions, but we must forge ahead.",
                            "Yes, uh, we will keep that in mind."},
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
                    new String[]{"Let's do some research, who knows what we'll find?",
                            "We keep going - we can't lose sight of why we're here"},
                    new String[]{"While deciphering old ship manifests, Amira realizes that the owners of EHE \n" +
                            "previously operated under a different name and did business with Eurydice's mentor.",
                            "The ship sails on"}),

            new StoryScene("\nIsh and Orlic set off on a hike to search for more food.(Island)", "N/A",
                    new String[]{"N/A","N/A"}, new String[]{"N/A","N/A"}),

            new StoryScene ("\nThe crew encounters a pair of natives in the middle of fishing who \n" +
                    "agree to show them the area. They explore a large cave system and make camp together ashore for the \n" +
                    "night. Amira chatters enthusiastically with the fishers about their culture, and they patiently \n" +
                    "describe a secret text they carry with them with information on a sacred grove of trees with \n" +
                    "magical properties. (Island)", "Night falls and everyone falls asleep. You see this sacred text tucked \n" +
                    "in the local woman's satchel. Do you take a peek? (Q)",
                    new String[]{"It's sacred, I should leave it alone.", "I'll look quickly - no one will know."},
                    new String[]{"\nYou pass a peaceful night.",
                            "\nYou find a simple map sketched in the first few pages, marking a location that seems \n" +
                                    "to be just one island north of here."}),

            new StoryScene ("\nFollowing the map, the crew drops anchor besides an island \n" +
                    "densely packed with strange-looking trees. Orlic, Eurydice and Amira take out a boat to explore \n" +
                    "further, and Amira notices traces of a thick brown substance that resembles an incredibly rare fuel \n" +
                    "her country has experimented with to make cutting-edge technology.(Island)", "Do you fill a vial with \n" +
                    "the tree sap or head back to the ship?(Q)",
                    new String[]{"No, best leave it be.","Yes, we need a sample to prove what we've seen."},
                    new String[]{"\nYou head back to the ship and sail away.","\nYou safely stow the substance in the ship hold."}),

            new StoryScene ("\nCas and Amira bond while exploring another island. (Island)",
                    "", new String[]{"",""}, new String[]{"",""}),

            new StoryScene ("\nEurydice receives a letter via bird from her mentor. It demands that \n" +
                    "the crew send the map immediately, being sure to highlight any potential obstacles to further \n" +
                    "exploration and expansion into the area. It's clear that plans are about to be underway. It's time " +
                    "to send the map",
                    "\nDo you want to go through with handing the map over to the mentor and whoever they're working with?(Q)",
                    new String[]{"No, I don't think it's a good idea","Yes, time is running out!"},
                    new String[]{"\nThe crew readies their things to start sailing home, the map" +
                            "locked safely into the ship vault.","\nEurydice carefully packages up all of your notes on everything you've seen, sending " +
                            "the bird back into the horizon."}),

            new StoryScene ("\nThe crew has made it home safely. \nEPILOGUE\n\nSix months later, " +
                    "Eurydice finally relents to Amira's requests to put together an expedition and visit their friends \n" +
                    "in the Eastern Islands. When they arrive, they learn what has happened with EHE. \nTHE END",
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
                    "The inhabitants of the islands are glad to see them, and share news about EHE. The crew is confident " +
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
                                "Give Meels a vial of medicine and keep her quarantined [requires 10 vials of medicine]"},
                        new String[]{"Now everyone's sick and there's no one to get fresh water! (-25 HEALTH)",
                                "Good call - she's feeling much better."},
                        0));
        all_obstacles.add(
                new Obstacle("----- WHY IS THE TOOTH FAIRY HERE? -----\n" +
                        "It seems like just eating hard tack and jerky is not the new keto after all, and now everyone has scurvy!",
                        new String[]{"Everyone knows that you cure scurvy by chewing licorice root",
                                "We'll divide our medicine stores evenly among everywhere [requires 10 vials of medicine]"},
                        new String[]{"Actually, I'm pretty sure Orlic's the one who said that... the crew remains weak \n" +
                                "until they're able to find fruit at the next island (-25 HEALTH)",
                                "The crew is bolstered enough to carry on"},1));
        all_obstacles.add(
                new Obstacle("----- SHIP MALFUNCTION -----\nUm... is that big wooden pole supposed to be in two pieces?",
                        new String[]{"Orlic comes up with a spool of rope and wooden spoon and offers to help",
                                "We better use some of our wood to construct a new mast here on the deck [requires 10 logs of wood]"},
                        new String[]{"Orlic thought you wanted her to build a swing - this ship won't be sailing anytime soon (-25 HEALTH)",
                                "It looks like that did the trick... for now"},2));
        all_obstacles.add(
                new Obstacle("----- WATER RISING -----\n" +
                        "It looks like an old repair in the bilge sprung a leak, and the water is already ankle deep!",
                        new String[]{"Grab a bucket - we'll bail it out one trip at a time",
                                "Use a hammer and nails to put new planks over the leak and seal it up [requires 10 logs of wood]"},
                        new String[]{"Good job! You remove three buckets of water... but the leak got bigger and the water's up to\n" +
                                "your waist - we'll have to seal off the lower decks (-25 HEALTH)",
                                "It worked! And now we have a hot tub! ... a warm, smelly hot tub..."},3));

        all_obstacles.add(
                new Obstacle("----- (WO)MAN OVERBOARD -----\n" +
                        "Meels used the plank as a runway again and fell right off the edge!",
                        new String[]{"We'll lower Cas down by her ankles to snatch her up",
                                "Lower some rope over the edge for her to grab on [requires 10 feet of rope]"},
                        new String[]{"Cas has so many weapons strapped to her that she falls in too, and both get pneumonia damn (-25 HEALTH)",
                                "She clambers back up gratefully"},4));
        all_obstacles.add(
                new Obstacle("----- SOUND OF SIRENS -----\n" +
                        "As the ship enters a rocky area, a pair of beautiful sirens on a cliff bewitch half the crew",
                        new String[]{"Amira suggests that we use the cork stoppers from the medicine vials \nto plug their ears [requires 10 vials of medicine]",
                                "Grab your fellow pirates and tie them to the masts before they jump over [requires 10 feet of rope]"},
                        new String[]{"'I CAN'T HEAR THEM ANYMORE! WHAT HAPPENED TO THE BEAUTIFUL WOMEN?' Cas yells. Guess it worked!",
                                "As Cas brandishes a sword and cuts away the rope, you realize that you may \n" +
                                        "have miscalculated how many weapons these pirates have, and the the crew hits \n" +
                                        "a rock as they distractedly swerve away (-25 HEALTH)"},5));
        all_obstacles.add(
                new Obstacle("----- IS OUR WOODEN SHIP ON FIRE??? -----\n" +
                        "Isha's foot is caught and they're stuck by the flames, but the inventory is about to catch fire!",
                        new String[]{"Ish will be fine, save the booty!",
                                "Run and help them!"},
                        new String[]{"Isha's ankle sustains minor burns, so they'll be on bed rest for awhile (-25 HEALTH)",
                                "Phew, we all made it! Looks like a few things got a little, uh... crispy"},6));

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
    public Island [] setIslands () {
        for (int i = 0; i < 12; i++) {
            all_islands[i].setStory(all_stories[i]);
        }
        return all_islands;
    }

    public StoryScene[] getScenes () {
        return all_stories;
    }



    //ArrayList<ResourceArea> resources = new ArrayList<ResourceArea>();


}

