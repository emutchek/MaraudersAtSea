package edu.vassar.cmpu203.maraudersatsea.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MapTest {
    /**
     * Tests map to string by
     * -verifying that at the beginning, the map is blank
     * -calling addIsland() to simulate the user discovering islands, and verifying that the map updates
     */
    @Test
    void testToString() {
        Library lib = new Library();
        Map m = new Map(lib.all_islands);
        String exp = "MAP OF THE EASTERN ISLANDS\n";
        assertEquals(exp, m.toString());

        m.addIsland(0);
        m.addIsland(1);
        exp += lib.all_islands[0] + "\n" + lib.all_islands[1] + "\n";
        assertEquals(exp, m.toString());
    }

    /**
     * Tests addIsland in the map class by
     * -verifying that all islands start as invisible
     * -adding a few islands to the map and checking that they've been turned visible, but others have not
     */
    @Test
    void addIsland() {
        Library lib = new Library();
        Map m = new Map(lib.all_islands);
        for(int i = 0; i < 12; i++) {
            assertFalse(m.all_islands[i].onMap);
        }

        m.addIsland(0);
        m.addIsland(1);
        assertTrue(m.all_islands[0].onMap);
        assertTrue(m.all_islands[1].onMap);
        for(int i = 2; i < 12; i++) {
            assertFalse(m.all_islands[i].onMap);
        }
    }
}