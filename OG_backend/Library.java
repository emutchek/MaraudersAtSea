package edu.vassar.cmpu203.maraudersatsea.model;

import java.util.ArrayList;
public class Library {
    StoryScene [] all_stories = {
            new StoryScene("Welcome to Marauders at Sea, an adventure that will test your mettle and heart." +
                    "Every pirate needs a good crew, so you'll be traveling with the very best. " +
                    "\nEURYDICE, the brave captain, " + "\nCASSEIOPIA 'CAS', the dashing first mate, " +
                    "\nAMIRA, the clever map maker, " + "\nAMELIA 'MEELS', the French cook, " + "\nISHA 'ISH', the peaceful surgeon, " +
                    "\nORLIC, the oddball gunner" + "\nStay safe out there, sailor. All hands hoay!" ,
                    "Pirate captain Eurydice receives a letter from her former boss " +
                            "requesting she take her crew and set off to do a charting mission of the Eastern Islands," +
                            "a mysterious far-flung territory guarded by dangerous waters.",
                    "”What do you think, sailor? Do we go?(Q)”",
                    new String[]{"“We can't cross the Eastern Islands, we'll be fish food!“",
                            "“Aye! We’ll rally the crew and give no quarter”"},
                    new String[]{"“Don’t be such a lily-livered wench. We’re going.”" +
                            "You round up all the crew, restock the ship, and set course for the Eastern Islands.",
                            "You round up all the crew, restock the ship, and set course for the Eastern Islands."}),

            new StoryScene("The crew make it to the edge of the territory of the Eastern Islands. " ,
                    "They stop to explore, but end up stuck in a pit and resorting to petty arguments.(Island)",
                    "N/A", new String[]{"N/A", "N/A"}, new String[]{"N/A", "N/A"}),

            new StoryScene("The crew reach another island, where Meels spots an orange tree and the crew " +
                    "gets caught by a local while helping themselves to the fruit.  " ,
                    "He asks what you're doing here. You explain your mission to make a map, and he " +
                    "warns you that no good will come of it and you should leave. (Island)",
                    "What do you say? (Q)",
                    new String[]{"We will remain vigilant about our actions, but we must forge ahead.",
                            "Yes, uh, we will keep that in mind."},
                    new String[]{"The man nods gravely and invites you in for a meal.", "The man looks disappointed, nods," +
                            " and walks away without another word."}),

            new StoryScene("During a particularly bad storm, Cas takes a tumble and gets hurt. ",
                    "Tensions are high and Ish has to put their surgery skills to good use.(Island) ",
                    "N/A", new String[]{"N/A", "N/A"}, new String[]{"N/A", "N/A"}),

            new StoryScene("Cas and Amira have a falling-out and come to better understand each " ,
                    "other.(Island)", "N/A", new String[]{"N/A", "N/A"}, new String[]{"N/A", "N/A"}),

            new StoryScene("Meels and Eurydice had gone off to explore another island, and come back with " +
                    "signs of other foreign explorers who had come before them, sponsored by a company called" ,
                    "Eastern Helion Expansion (EHE). Cas knows EHE to be an antagonistic group who've recently exploded " +
                    "with unexplained profits. (Island)",
                    "Do you stick around here to comb for more evidence or press on in order to meet the deadline?(Q)",
                    new String[]{"Let's do some research, who knows what we'll find?",
                            "We keep going - we can't lose sight of why we're here"},
                    new String[]{"While deciphering old ship manifests, Amira realizes that the owners of EHE " +
                            "previously operated under a different name and did business with Eurydice's mentor.",
                            "The ship sails on"}),

            new StoryScene("Ish and Orlic set off on a hike", "to search for more food.(Island)", "N/A",
                    new String[]{"N/A","N/A"}, new String[]{"N/A","N/A"}),

            new StoryScene ("The crew encounters a pair of natives in the middle of fishing who " +
                    "agree to show them the area. They explore a large cave system and make camp together ashore for the " +
                    "night. Amira chatters enthusiastically with the fishers about their culture, and they patiently " ,
                    "describe a secret text they carry with them with information on a sacred grove of trees with " +
                    "magical properties. (Island)", "Night falls and everyone falls asleep. You see this sacred text tucked " +
                    "in the local woman's satchel. Do you take a peek? (Q)",
                    new String[]{"It's sacred, I should leave it alone.", "I'll look quickly - no one will know."},
                    new String[]{"You pass a peaceful night.",
                            "You find a simple map sketched in the first few pages, marking a location that seems " +
                                    "to be just one island north of here."}),

            new StoryScene ("Following the map, the crew drops anchor besides an island " +
                    "densely packed with strange-looking trees. Orlic, Eurydice and Amira take out a boat to explore " ,
                    "further, and Amira notices traces of a thick brown substance that resembles an incredibly rare fuel " +
                    "her country has experimented with to make cutting-edge technology.(Island)", "Do you fill a vial with " +
                    "the tree sap or head back to the ship?(Q)",
                    new String[]{"No, best leave it be.","Yes, we need a sample to prove what we've seen."},
                    new String[]{"You head back to the ship and sail away.","You safely stow the substance in the ship hold."}),

            new StoryScene ("Cas and Amira bond while"," exploring another island. (Island)",
                    "N/A", new String[]{"N/A","N/A"}, new String[]{"N/A","N/A"}),

            new StoryScene ("Eurydice receives a letter via bird from her mentor. It demands that " +
                    "the crew send the map immediately, being sure to highlight any potential obstacles to further " ,
                    "exploration and expansion into the area. It's clear that plans are about to be underway. It's time " +
                    "to send the map",
                    "Do you want to go through with handing the map over to the mentor and whoever they're working with?(Q)",
                    new String[]{"No, I don't think it's a good idea","Yes, time is running out!"},
                    new String[]{"The crew readies their things to start sailing home, the map" +
                            "locked safely into the ship vault.","Eurydice carefully packages up all of your notes on everything you've seen, sending " +
                            "the bird back into the horizon."}),

            new StoryScene ("The crew has made it home safely. EPILOGUE \nSix months later, " +
                    "Eurydice finally relents to Amira's requests to put together an expedition and visit their friends " ,
                    "in the Eastern Islands. When they arrive, they learn what has happened with EHE. THE END",
                    "N/A", new String[]{"N/A","N/A"}, new String[]{"N/A","N/A"}),
    } ;

    public StoryScene[] all_secstories = {
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            new StoryScene ("The next morning, the locals invite the crew to attend a " +
                    "nearby festival with them. Everyone dresses in their finest and joins milling crowds for a night " +
                    "of music and dance. They get to chatting with some of the inhabitants, who mention that there " ,
                    "are hostile forces planning something bad for the Eastern Islands.(Island)",
                    "Do you warn them about what you know?(Q)", new String[]{"We'll tell them everything we know.",
                    "Better keep it to ourselves - we don't know how they'll react."}, new String[]{"The locals thank " +
                    "you for the information and urge you to keep in touch","After the party you head back to the ship."}),
            null,
            null,
            new StoryScene ("Congratulations! The crew has made it home safely. EPILOGUESix months later, " +
                    "Eurydice finally relents to Amira's requests to put together an expedition and visit their friends " ,
                    "in the Eastern Islands. They stock up plenty of fruit this time and enjoy calm waters on the voyage. " +
                    "The inhabitants of the islands are glad to see them, and share news about EHE. The crew is confident " +
                    "that they did the right thing. THE END",
                    "N/A", new String[]{"N/A","N/A"}, new String[]{"N/A","N/A"}),
    };

    public ArrayList<Obstacle> all_obstacles = new ArrayList<Obstacle>();

    public Library() {
        all_obstacles.add(
                new Obstacle("☠ PLAGUE ALERT ☠" +
                        "\nMeels woke up this morning covered in boils. We must have incurred the wrath of an angry spirit... or " +
                        "maybe it was the brownish drinking water. What do you do?",
                        new String[]{"People get sick all the time! Let's play limbo on the deck",
                                "Give Meels medicine and keep her quarantined [10 vials of medicine]"},
                        new String[]{"Now everyone's sick and there's no one to get fresh water! (-25 HEALTH)",
                                "Good call - she's feeling much better."},
                        0));
        all_obstacles.add(
                new Obstacle("WHY IS THE TOOTH FAIRY HERE?" +
                        "\nIt seems like just eating hard tack and jerky is not the new keto after all, and now everyone has scurvy!",
                        new String[]{"Everyone knows that you cure scurvy by chewing licorice root",
                                "We'll divide our medicine stores evenly [10 vials of medicine]"},
                        new String[]{"Actually, it was Orlic who said that... the crew remains weak " +
                                "for days (-25 HEALTH)",
                                "The crew is bolstered enough to carry on"},1));
        all_obstacles.add(
                new Obstacle("SHIP MALFUNCTION \nUm... is that big wooden pole supposed to be in two pieces?",
                        new String[]{"Orlic comes up with a saw and offers to help",
                                "Construct a new mast here on the deck [10 logs of wood]"},
                        new String[]{"Orlic built a swing instead - this ship won't be sailing anytime soon (-25 HEALTH)",
                                "It looks like that did the trick... for now"},2));
        all_obstacles.add(
                new Obstacle("WATER RISING" +
                        "\nAn old repair in the bilge sprung a leak, and the water is already ankle deep!",
                        new String[]{"We'll bail it out one trip at a time",
                                "Put new planks over the leak and seal it up [10 logs of wood]"},
                        new String[]{"You remove three buckets of water, but the water's up to" +
                                "your waist - we'll have to seal off the lower decks (-25 HEALTH)",
                                "It worked! And now we have a hot tub! ... a warm, smelly hot tub..."},3));

        all_obstacles.add(
                new Obstacle("(WO)MAN OVERBOARD" +
                        "\nMeels used the plank as a runway again and fell right off the edge!",
                        new String[]{"We'll lower Cas down by her ankles to snatch her up",
                                "Lower some rope over the edge for her to grab on [10 spools of rope]"},
                        new String[]{"Cas has so many weapons that she falls in too, and both get pneumonia (-25 HEALTH)",
                                "She clambers back up gratefully"},4));
        all_obstacles.add(
                new Obstacle("SOUND OF SIRENS" +
                        "\nA pair of beautiful sirens on a cliff bewitch half the crew",
                        new String[]{"Amira suggests we plug our ears with cork[10 vials of medicine]",
                                "Tie your crewmates to the masts before they jump over [10 spools of rope]"},
                        new String[]{"'I CAN'T HEAR THEM ANYMORE! WHAT HAPPENED TO THE BEAUTIFUL WOMEN?' Cas yells. Guess it worked!",
                                "Cas brandishes a sword and cuts away the rope - " +
                                        " you miscalculated how many weapons these pirates have (-25 HEALTH)"},5));
        all_obstacles.add(
                new Obstacle("IS OUR WOODEN SHIP ON FIRE???" +
                        "\nIsha's foot is caught and they're stuck by the flames, but the inventory is about to catch fire!",
                        new String[]{"Ish will be fine, save the booty!",
                                "Run and help them!"},
                        new String[]{"Isha's ankle sustains minor burns, so they'll be on bed rest for awhile (-25 HEALTH)",
                                "Phew, we all made it! Looks like a few things got a little, uh... crispy"},6));

    }

    public Island [] all_islands = {
            new Island("The Isle of Graves"),
            new Island("The Pitt"),
            new Island("Orange Forests"),
            new Island("Rocky Rapids"),
            new Island("High Peaks"),
            new Island("Dunes"),
            new Island("Grotto"),
            new Island("Caves"),
            new Island("The Grove/The Meeting Place"),
            new Island("Beach"),
            new Island("The Border"),
            new Island("Ending"),
    };

    /**
     * Sets the StoryScene field in each island object
     * @return edited list of islands
     */
    public void setIslands () {
        for (int i = 0; i < 12; i++) {
            all_islands[i].setStory(all_stories[i]);
        }

    }

    public StoryScene[] getScenes () {
        return all_stories;
    }



    //ArrayList<ResourceArea> resources = new ArrayList<ResourceArea>();


}

