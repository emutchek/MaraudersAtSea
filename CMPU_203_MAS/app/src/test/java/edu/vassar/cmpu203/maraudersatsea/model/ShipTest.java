package edu.vassar.cmpu203.maraudersatsea.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShipTest {

    @Test
    void updateHealth() {
        Ship s = new Ship();
        //ship health starts as 100
        //try to add health while ship health is greater than 75%
        s.updateHealth(25);
        assertEquals(100, s.health);
        s.health = 76;
        s.updateHealth(25);
        assertEquals(100, s.health);
        //try to add health while less than or equal to 75%
        s.health = 75;
        s.updateHealth(25);
        assertEquals(100, s.health);
        s.health = 65;
        s.updateHealth(25);
        assertEquals(90, s.health);
        //try to add negative health
        s.health = 75;
        s.updateHealth(-25);
        assertEquals(50, s.health);
        //try to add negative health when health == 0
        s.health = 0;
        s.updateHealth(-25);
        assertEquals(0, s.health);
        //try to add negative health when health > 0 but adding will make it < 0
        s.health = 5;
        s.updateHealth(-25);
        assertEquals(0, s.health);
    }

    @Test
    void testToString(){
        Ship s = new Ship();
        String str = "Ship health: " + 100;
        assertEquals(str, s.toString());
    }
}