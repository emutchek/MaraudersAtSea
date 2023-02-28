public class Inventory {
    int rope;
    int wood;
    int medicine;

    public Inventory(){
        rope = 0;
        wood = 0;
        medicine = 0;
    }

    public void updateInventory(ResourceArea r){
        switch (r.description) {
            case "rope":
                rope++;
                break;
            case "medicine":
                medicine++;
                break;
            case "wood":
                wood++;
                break;
        }
    }

    public String toString(){
        return "INVENTORY: \n" + "Rope: " + rope + "\nWood: " + wood + "\nMedicine: " + medicine;
    }
}
