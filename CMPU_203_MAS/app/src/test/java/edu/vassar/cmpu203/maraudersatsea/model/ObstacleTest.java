package edu.vassar.cmpu203.maraudersatsea.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ObstacleTest {

    @Test
    void testToString() {
        Obstacle obs = new Obstacle("Insert ridiculous obstacle",
                new String[]{"Orlic has something in her pocket", "Meels flips her hair dramatically"},
                new String[]{"Amira made the perfect cuppa", "Cas leaps overboard"}, 0);
        String str = "OBSTACLE:\n" + "Insert ridiculous obstacle" +
                "\n\nChoose action A or B\n\nA: " + "Orlic has something in her pocket" +
                "\nor\nB: " + "Meels flips her hair dramatically";
        assertEquals(str, obs.toString());
    }

    @Test
    void returnObsEnding() {
        Obstacle obs = new Obstacle("Insert ridiculous obstacle",
                new String[]{"Orlic has something in her pocket", "Meels flips her hair dramatically"},
                new String[]{"Amira made the perfect cuppa", "Cas leaps overboard"}, 0);
        String a = "Amira made the perfect cuppa";
        assertEquals(a, obs.returnObsEnding('A'));
        String b = "Cas leaps overboard";
        assertEquals(b, obs.returnObsEnding('B'));
    }
}