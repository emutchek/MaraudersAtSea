public class Ship {
    int health;

    public Ship(){
        health = 100;
    }

    public void updateHealth(int amt){
        health = health+amt;
    }

    public String toString(){
        return "Ship health: " + health;
    }
}
