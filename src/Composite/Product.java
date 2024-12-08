package Composite;

public class Product extends InventoryComponent {
    private String name;
    private double price;
    private int quantity;  // We add new quantity property

    
    public Product(int id, String name, double price, int quantity) {
        super(id);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void display() {
        System.out.println("Product ID: " + getId());
        System.out.println("Product Name: " + name);
        System.out.println("Product Price: " + price);
        System.out.println("Product Quantity: " + quantity);  
    }
}
