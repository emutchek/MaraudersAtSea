public class Ship {
    int health;

    public Ship(){
        health = 0;
    }

    public void updateHealth(int amt){
        health = health+amt;
    }

    public String toString(){
        return "Ship health: " + health;
    }
}
