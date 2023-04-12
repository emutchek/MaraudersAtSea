package edu.vassar.cmpu203.maraudersatsea.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ResourceAreaTest {

    @Test
    void testRAType(){
        float ropeRA=0;
        float woodRA=0;
        float medRA=0;
        for(int i=0; i<100; i++){
            ResourceArea temp = new ResourceArea();
            if (temp.description == "rope"){
                ropeRA++;
            } else if (temp.description == "wood") {
                woodRA++;
            }
            else{
                medRA++;
            }
        }
        ropeRA /= 100;
        woodRA /= 100;
        medRA /= 100;
        //make sure there is about 1/3 chance of each time of resource area generating
        assertTrue(ropeRA > 0.20 && ropeRA < 0.45);
        assertTrue(woodRA > 0.20 && woodRA < 0.45);
        assertTrue(medRA > 0.20 && medRA < 0.45);
    }

    @Test
    void displayCards() {
        ResourceArea ra = new ResourceArea();
        String str = "";
        if (ra.description == "rope"){str = "rope";}
        else if (ra.description == "wood") {str = "wood";}
        else{str = "medicine";}
        String cmp = "Oh look! Some " + str + ". Do you want to grab it? A for yes, B for no (Q)";
        assertEquals(cmp, ra.displayCards());
    }
}