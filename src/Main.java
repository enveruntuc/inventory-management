import Composite.Product;
import Singleton.Inventory;
import Observer.StockObserver;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = Inventory.getInstance();


        StockObserver stockObserver = new StockObserver("enver","untuç",22);
        inventory.attach(stockObserver);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Inventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Display Products");
            System.out.println("4. Add Stock Observer");
            System.out.println("5. Remove Stock Observer");
            System.out.println("6. Exit");

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Clear the buffer

                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine(); // Now allows multi-word input

                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();

                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();


                    Product product = new Product(id, name, price, quantity);

                    inventory.addProduct(product);


                    break;

                case 2:
                    System.out.print("Enter product ID to remove: ");
                    int removeId = scanner.nextInt();
                    inventory.removeProduct(removeId);
                    break;

                case 3:
                    System.out.print("Do you want to display a specific product by ID? (yes/no): ");
                    String response = scanner.nextLine().trim().toLowerCase();

                    if (response.equals("yes")) {
                        System.out.print("Enter product ID to display: ");
                        int displayId = scanner.nextInt();
                        inventory.displayProductById(displayId);
                    } else {
                        inventory.displayAllProducts();
                    }
                    break;

                case 4:
                    System.out.println("Enter Observer Name:");
                    String customerName = scanner.nextLine();
                    System.out.println("Enter Observer Surname:");
                    String customerSurname = scanner.nextLine();
                    System.out.println("Enter Observer ID:");
                    int customerId = scanner.nextInt();
                    stockObserver = new StockObserver(customerName, customerSurname, customerId);
                    inventory.attach(stockObserver);
                    break;

                case 5:
                    System.out.println("Enter Observer ID to Remove:");
                    int removeCustomerId = scanner.nextInt();
                    inventory.getObservers().removeIf(o -> {
                        if (o instanceof StockObserver) {
                            return ((StockObserver) o).getId() == removeCustomerId;
                        }
                        return false;
                    });

                    System.out.println("Observer with ID " + removeCustomerId + " removed (if existed).");
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

}