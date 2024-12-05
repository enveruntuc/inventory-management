package Observer;

import Composite.Product;

public class StockObserver implements InventoryObserver {
    @Override
    public void update(Product product) {
        System.out.println("Stock Updated: " + product.getQuantity() + " units of " + product + " left.");
    }
}