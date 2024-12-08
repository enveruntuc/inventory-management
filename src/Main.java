import Composite.*;
import Singleton.Inventory;
import Observer.StockObserver;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = Inventory.getInstance();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Inventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Display Item");
            System.out.println("4. Add Stock Observer");
            System.out.println("5. Remove Stock Observer");
            System.out.println("6. Exit");

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Would you like to add a product or category? (1 -> Product, 2 -> Category)");
                    int check = scanner.nextInt();

                    System.out.print("Enter item ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Clear the buffer

                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine(); // Now allows multi-word input

                    if(check == 1){
                        System.out.print("Enter item price: ");
                        double price = scanner.nextDouble();

                        System.out.print("Enter item quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Which category would you like to add this product? (Enter its id from list below)");
                        inventory.displayCategories();
                        int categoryId = scanner.nextInt();

                        Product product = new Product(id, name, price, quantity);
                        inventory.addProduct(product);
                       
                        Category temp = inventory.getCategoryById(categoryId);
                        temp.add(product);
                        product.addCategory(temp);
                    }else if(check == 2) {
                        Category product = new Category(id, name);
                        inventory.addProduct(product);
                    } else {
                        System.out.println("Invalid option was chosen..");
                    }

                    break;

                case 2:
                    System.out.print("Enter product ID to remove: ");
                    int removeId = scanner.nextInt();
                    inventory.removeItem(removeId);
                    break;

                case 3:
                    System.out.print("Do you want to display a specific item by ID? (yes/no): ");
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
                    System.out.println("Enter Observer Name: ");
                    String customerName = scanner.nextLine();
                    System.out.println("Enter Observer Surname: ");
                    String customerSurname = scanner.nextLine();
                    System.out.println("Enter Observer ID: ");
                    int customerId = scanner.nextInt();
                    StockObserver stockObserver = new StockObserver(customerName, customerSurname, customerId);
                    inventory.attach(stockObserver);
                    break;

                case 5:
                    System.out.println("Enter Observer ID to Remove: ");
                    int removeCustomerId = scanner.nextInt();
                    boolean temp = inventory.getObservers().removeIf(o -> {
                        if (o instanceof StockObserver) {
                            return ((StockObserver) o).getId() == removeCustomerId;
                        }
                        return false;
                    });

                    if(temp) {
                        System.out.println("Observer with ID '" + removeCustomerId + "' removed.");
                    }else {
                        System.out.println("Could not find the observer with ID '" + removeCustomerId + "'.");
                    }
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