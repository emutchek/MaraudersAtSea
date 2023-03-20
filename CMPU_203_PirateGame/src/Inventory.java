public class Inventory {
    int rope;
    int wood;
    int medicine;
    static int max = 170;

    public Inventory(){
        rope = 50;
        wood = 50;
        medicine = 50;
    }

    public void addToInventory(ResourceArea r){
        switch (r.description) {
            case "rope":
                rope+=10;
                break;
            case "medicine":
                medicine+=10;
                break;
            default:
                wood+=10;
                break;
        }
    }

    public void removeInventory(char c) {
        switch (c) {
            case 'R':
                rope-=30;
                break;
            case 'M':
                medicine-=30;
                break;
            case 'W':
                wood-=30;
                break;
        }
    }

    public boolean isFull() {
        return (this.rope+this.wood+this.medicine >= this.max);
    }

    public String toString(){
        return "INVENTORY: \n" + "Rope: " + rope + " ft\nWood: " + wood + " logs\nMedicine: " + medicine + " oz";
    }
}
