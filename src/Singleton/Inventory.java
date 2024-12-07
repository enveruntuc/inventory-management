package Singleton;

import Composite.Product;          // Composite paketinden Product sınıfı import edilmiştir.
import Observer.InventorySubject;  // Observer paketinden InventorySubject sınıfı import edilmiştir.
import Observer.InventoryObserver;
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
        } else {
            System.out.println("Product already exists.");
        }
    }

    public void updateProductQuantity(int productId, int quantity) {
        for (Product p : products) {
            if (p.getId() == productId) {
                p.setQuantity(quantity);
                notifyObservers(p);
            }
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
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayProducts() {
        for (Product p : products) {
            p.display();
        }
    }
}
