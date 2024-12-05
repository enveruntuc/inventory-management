package Composite;

public class Product extends InventoryComponent {
    private String name;
    private int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
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
}