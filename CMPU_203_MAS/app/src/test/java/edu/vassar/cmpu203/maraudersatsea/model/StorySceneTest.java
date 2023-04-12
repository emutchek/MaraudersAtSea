package edu.vassar.cmpu203.maraudersatsea.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StorySceneTest {

    @Test
    void returnEnding() {
        StoryScene ss = new StoryScene("Complicit in oppresive structures n regimes!!",
                "Self awareness is cool", "Use critical thinking?",
                new String[]{"yes", "no"}, new String[]{"yay!", "awwh :("});
        String a = "yay!";
        assertEquals(a, ss.returnEnding('A'));
        String b = "awwh :(";
        assertEquals(b, ss.returnEnding('B'));
    }
}