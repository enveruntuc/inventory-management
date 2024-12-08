package Composite;

import java.util.ArrayList;
import java.util.List;

public class Product extends InventoryComponent {
    private String name;
    private double price;
    private int quantity;  // We add new quantity property
    private List<Category> categories;

    
    public Product(int id, String name, double price, int quantity) {
        super(id);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        categories = new ArrayList<>();
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

    public List<Category> getCategories(){
        return categories;
    }

    public void addCategory(Category tempCategory) {
        categories.add(tempCategory);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void display() {
        System.out.println("Product ID: " + getId());
        System.out.println("Product Name: " + name);
        System.out.println("Product Price: " + price);
        System.out.println("Product Quantity: " + quantity);
        for (Category category : categories) {
            category.display();
        }  
    }
}
