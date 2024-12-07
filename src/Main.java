import Composite.Product;
import Composite.Category;
import Singleton.Inventory;
import Observer.StockObserver;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = Inventory.getInstance();

        // We add StockObserver to inventory
        StockObserver stockObserver = new StockObserver();
        inventory.attach(stockObserver);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nWelcome to the Inventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Display Products");
            System.out.println("4. Exit");

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter product ID: ");
                int id = scanner.nextInt();
                System.out.print("Enter product name: ");
                String name = scanner.next();
                System.out.print("Enter product price: ");
                double price = scanner.nextDouble();
                System.out.print("Enter product quantity: ");
                int quantity = scanner.nextInt();
                
                // Create the product
                Product product = new Product(id, name, price, quantity);
                
                inventory.addProduct(product);
            } 
            else if (choice == 2) {
                System.out.print("Enter product ID to remove: ");
                int id = scanner.nextInt();
                inventory.removeProduct(id);
            } 
            else if (choice == 3) {
                inventory.displayProducts();
            } 
            else if (choice == 4) {
                System.out.println("Exiting...");
                break;
            } 
            else {
                System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }
}
