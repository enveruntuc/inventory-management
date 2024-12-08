package Composite;

public class Product extends InventoryComponent {
    private int id;
    private String name;
    private double price;
    private int quantity;  // We add new quantity property

    
    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    


    public int getId() {
        return id;
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
        System.out.println("Product ID: " + id);
        System.out.println("Product Name: " + name);
        System.out.println("Product Price: " + price);
        System.out.println("Product Quantity: " + quantity);  
    }
}
