package Composite;

public class Product extends InventoryComponent {
    private String name;
    private int quantity;
    private int ID;

    public Product(String name, int quantity, int ID) {
        this.name = name;
        this.quantity = quantity;
        this.ID = ID;
    }

    @Override
    public void display() {
        System.out.println("Product: " + name + ", Quantity: " + quantity);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getID() {
        return ID;
    }
}