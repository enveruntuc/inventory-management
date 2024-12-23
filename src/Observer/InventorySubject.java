package Observer;

import Composite.Product;
import java.util.ArrayList;
import java.util.List;

public abstract class InventorySubject {
    private List<InventoryObserver> observers;

    public InventorySubject() {
        observers = new ArrayList<>();
    }

    public void attach(InventoryObserver observer) {
        observers.add(observer);
    }

    public void detach(InventoryObserver observer) {
        observers.remove(observer);
    }

    public List<InventoryObserver> getObservers() {
        return observers;
    }

    public void notifyObservers(Product product) {
        for (InventoryObserver observer : observers) {
            observer.update(product);
        }
    }
}
