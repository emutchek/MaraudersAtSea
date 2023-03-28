package edu.vassar.cmpu203.maraudersatsea.model;

public class Ship {
    int health;

    public Ship(){
        health = 100;
    }

    public void updateHealth(int amt){
        if(health <= 75) {
            health = health+amt;
        }
    }

    public String toString(){
        return "Ship health: " + health;
    }
}
