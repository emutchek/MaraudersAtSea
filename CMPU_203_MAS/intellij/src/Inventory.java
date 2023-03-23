public class Inventory {
    int rope;
    int wood;
    int medicine;
    static int max = 90;

    public Inventory(){
        rope = 20;
        wood = 20;
        medicine = 20;
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
                if (rope != 0) {
                    rope -= 10;
                }
                break;
            case 'M':
                if (medicine != 0) {
                    medicine -= 10;
                }
                break;
            case 'W':
                if (wood != 0) {
                    wood -= 10;
                }
                break;
        }
    }

    public boolean isFull() {
        return (this.rope+this.wood+this.medicine >= this.max);
    }

    public String toString(){
        return "INVENTORY: \n" + "Rope: " + rope + " ft\nWood: " + wood + " logs\nMedicine: " + medicine + " vials";
    }
}
