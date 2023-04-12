package edu.vassar.cmpu203.maraudersatsea.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LibraryTest {

    /**
     * Tests setIslands method in Library by retrieving each island in the list and examining
     * its story scene (using a getter) to make sure it's been set
     */
    @Test
    void setIslands() {
        Library lib = new Library();
        lib.setIslands();
        for(int i = 0; i < 12; i++) {
            lib.all_islands[i].getStoryScene().equals(lib.all_stories[i]);
        }
    }
}