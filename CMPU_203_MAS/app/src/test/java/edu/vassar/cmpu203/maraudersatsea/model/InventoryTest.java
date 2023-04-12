package edu.vassar.cmpu203.maraudersatsea.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InventoryTest {

    /**
     * Tests the addToInventory method in Inventory by:
     * -verifying default values upon creation for wood, medicine, rope
     * -creating a random ResourceArea and confirming that it updates correct field when added
     *  to inventory
     */
    @Test
    void addToInventory() {
        Inventory inv = new Inventory();
        assertEquals(20, inv.rope);
        assertEquals(20, inv.wood);
        assertEquals(20, inv.medicine);

        ResourceArea ra = new ResourceArea();
        inv.addToInventory(ra);
        if(ra.description.equals("rope")) assertEquals(30, inv.rope);
        else if(ra.description.equals("wood")) assertEquals(30, inv.wood);
        else assertEquals(30, inv.medicine);
    }
    /**
     * Tests the removeInventory method in Inventory by:
     * -calling method with two of the possible characters
     * -verifying that the correct fields are decremented and the others are unchanged
     */
    @Test
    void removeInventory() {
        Inventory inv = new Inventory();
        inv.removeInventory('R');
        assertEquals(10, inv.rope);
        assertEquals(20, inv.medicine);
        assertEquals(20, inv.wood);

        inv.removeInventory('M');
        assertEquals(10, inv.rope);
        assertEquals(10, inv.medicine);
        assertEquals(20, inv.wood);
    }
    /**
     * Tests the isFull method in Inventory by:
     * -calling method on a brand new Inventory object, which shouldn't be full
     * -adding items that remain below the limit to verify that it isn't full
     * -filling up the inventory and verifying that it is full
     */
    @Test
    void isFull() {
        Inventory inv = new Inventory();
        assertFalse(inv.isFull());

        ResourceArea ra = new ResourceArea();
        inv.addToInventory(ra);
        inv.addToInventory(ra);
        assertFalse(inv.isFull());

        inv.addToInventory(ra);
        assertTrue(inv.isFull());
    }

    /**
     * Tests the toString method in the Inventory class by comparing result to expected string
     */
    @Test
    void testToString() {
        Inventory inv = new Inventory();
        String exp = "INVENTORY: \n" + "Rope: " + 20 + " ft\nWood: " + 20 + " logs\nMedicine: " + 20 + " vials";
        assertEquals(exp,inv.toString());
    }
}