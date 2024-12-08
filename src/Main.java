import Composite.Product;
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
            System.out.println("3. Display Product by ID");
            System.out.println("4. Display All Products");
            System.out.println("5. Exit");

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer after nextInt()

            if (choice == 1) {
                System.out.print("Enter product ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer

                System.out.print("Enter product name: ");
                String name = scanner.nextLine(); // Now allows multi-word input

                System.out.print("Enter product price: ");
                double price = scanner.nextDouble();

                System.out.print("Enter product quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer

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
                System.out.print("Enter product ID to display: ");
                int id = scanner.nextInt();
                inventory.displayProductById(id);
            } 
            else if (choice == 4) {
                inventory.displayAllProducts();
            }
            else if (choice == 5) {
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