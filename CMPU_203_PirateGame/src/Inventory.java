public class Inventory {
    int rope;
    int wood;

    public Inventory(){
        rope = 0;
        wood = 0;
    }

    public void update_Inventory(int r, int w){
        this.rope = rope+r;
        this.wood = wood+w;
    }

    public String toString(){
        return "INVENTORY: \n" + "Rope: " + rope + "\nWood: " + wood;
    }
}
