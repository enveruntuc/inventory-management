package Singleton;

import Composite.Product;
import Observer.InventoryObserver;
import Observer.InventorySubject;
import java.util.ArrayList;
import java.util.List;

public class Inventory extends InventorySubject {
    private static Inventory inventory;
    private static List<Product> products;

    private Inventory() { 
        products = new ArrayList<>();
    }

    public static synchronized Inventory getInstance() {
        if (inventory == null) 
            inventory = new Inventory();
        return inventory;
    }

    public void addProduct(Product product) {
        if (products.stream().noneMatch(p -> p.getId() == product.getId())) {
            products.add(product);
            System.out.println("Product added: " + product.getName());
            notifyObservers(product); // Notify observers when a product is added
        } else {
            System.out.println("Product already exists.");
        }
    }

    public void removeProduct(int productId) {
        Product productToRemove = null;
        for (Product p : products) {
            if (p.getId() == productId) {
                productToRemove = p;
                break;
            }
        }

        if (productToRemove != null) {
            products.remove(productToRemove);
            System.out.println("Product removed: " + productToRemove.getName());
            notifyObservers(productToRemove); // Notify observers when a product is removed
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }
        
        System.out.println("All Products in Inventory:");
        for (Product p : products) {
            System.out.println("ID: " + p.getId() + ", Name: " + p.getName());
        }
    }

    public void displayProductById(int productId) {
        for (Product p : products) {
            if (p.getId() == productId) {
                System.out.println("Product Details:");
                p.display(); // Assuming Product has a display method
                return;
            }
        }
        System.out.println("Product not found with ID: " + productId);
    }
    public List<InventoryObserver> getObservers() {
        return getObservers();
    }
}