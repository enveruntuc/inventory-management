package Singleton;

import Composite.Category;
import Composite.InventoryComponent;
import Composite.Product;
import Observer.InventoryObserver;
import Observer.InventorySubject;
import java.util.ArrayList;
import java.util.List;

public class Inventory extends InventorySubject {
    private static Inventory inventory;
    private static List<InventoryComponent> products;

    private Inventory() { 
        super();
        products = new ArrayList<>();
    }

    public static synchronized Inventory getInstance() {
        if (inventory == null) 
            inventory = new Inventory();
        return inventory;
    }

    public void addProduct(InventoryComponent product) {
        if(product instanceof Product){
            Product product2 = (Product) product;
            if (products.stream().noneMatch(p -> p.getId() == product2.getId())) {
                products.add(product2);
                System.out.println("Product added: " + product2.getName());
                notifyObservers(product2);
            } else {
                System.out.println("Product already exists.");
            }
        } else {
            if(products.stream().noneMatch(p -> p.getId() == product.getId())){
                products.add(product);
                System.out.println("Category with id: " + product.getId() + "and name: " + ((Category) product).getName() + " was added.");
            }
            else {
                System.out.println("Category already exists.");
            }
        }
    }

    public void removeItem(int itemId) {
        InventoryComponent productToRemove = null;
        for (InventoryComponent p : products) {
            if (p.getId() == itemId) {
                productToRemove = p;
                break;
            }
        }

        if (productToRemove != null) {
            if(productToRemove instanceof Product){
                Product temp = (Product) productToRemove;
                products.remove(productToRemove);
                System.out.println("Product removed: " + temp.getName());
                notifyObservers(temp);
            }else if(productToRemove instanceof Category) {
                products.remove(productToRemove);
                System.out.println("Category with id no. " + itemId + " is deleted..");
            }
        } else {
            System.out.println("Product could not be found..");
        }
    }

    public Category getCategoryById(int itemId) {
        for(InventoryComponent p : products) {
            if(p.getId() == itemId && p instanceof Category) {
                return (Category) p;
            }
        }

        return null;
    }

    public Product getProductById(int itemId) {
        for(InventoryComponent p : products) {
            if(p.getId() == itemId && p instanceof Product) {
                return (Product) p;
            }
        }

        return null;
    }

    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }
        
        System.out.println("All Products in Inventory:");
        for (InventoryComponent p : products) {
            p.display();
        }
    }

    public void displayCategories() {
        if(products.isEmpty()) {
            System.out.println("No items in inventory yet.");
            return;
        }

        for(InventoryComponent p : products) {
            if (p instanceof Category) {
                p.display();
            }
        } 
    }

    public void displayProductById(int productId) {
        if(products.stream().noneMatch(p -> p.getId() == productId)) {
            System.out.println("No product found..");
        }else {
            for(InventoryComponent p : products) {
                if(p.getId() == productId) {
                    p.display();
                }
            }
        }
    }

    public List<InventoryObserver> getObservers() {
        return super.getObservers();
    }

}