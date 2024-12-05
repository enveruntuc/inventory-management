package Singleton;

import java.util.ArrayList;
import java.util.List;

import Composite.Product;
import Observer.*;

public class Inventory extends InventorySubject{
    private static Inventory inventory;
    private static List<Product> products;

    private Inventory() { 
        products = new ArrayList<>();
    }

    public static synchronized Inventory getInstance() {
        if(inventory == null) 
            inventory = new Inventory();

        return inventory;
    }

    public static void addProduct(Product product) {
        if(products.indexOf(product) != -1) {
            products.add(product);
        }
    }

    public static void updateProductQuantity(int productID, int quantity) {
        for(Product p : products) {
            if(p.getID() == productID) {
                p.setQuantity(quantity);
                inventory.notifyObservers(p);
            }
        }
    }

    public static void removeProduct(int productID) {
        for(Product p : products) {
            if (p.getID() == productID) {
                products.remove(p);
            }
        }
    }

    public static void checkStock(int productID) {
        for(Product p : products) {
            if(p.getID() == productID) { 
                int temp = p.getQuantity();

                if(temp > 0) {
                    System.out.println("Stock quantity is " + temp);
                } else {
                    System.out.println("This product is no longer in stock.");
                }
            }
        }
    }

}
