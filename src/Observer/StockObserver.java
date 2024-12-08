package Observer;

import Composite.Product;

public class StockObserver implements InventoryObserver {
    private String name;
    private String surname;
    private int id;

    public StockObserver(String name, String surname, int id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }
    @Override
    public void update(Product product) {
        System.out.println("Stock Updated: " + product.getQuantity() + " units of " + product.getName() +"  ----   "+ "notified customer " + getName() +" " + getSurname());
    }
}
