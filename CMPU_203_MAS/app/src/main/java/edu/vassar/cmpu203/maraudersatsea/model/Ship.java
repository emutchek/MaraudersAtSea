package edu.vassar.cmpu203.maraudersatsea.model;

public class Ship {
    public int health;

    public Ship(){
        health = 100;
    }

    public void updateHealth(int amt){
        int temphealth = this.health+amt;
        if(temphealth <= 100 && temphealth >= 0) {
            health = temphealth;
        } else if (temphealth < 0) {
            health = 0;
        }
        else if (temphealth > 100){
            health = 100;
        }
    }

    public String toString(){
        return "Ship health: " + health;
    }
}
