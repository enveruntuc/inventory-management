package Composite;

public abstract class InventoryComponent {
    public void add(InventoryComponent component) {
        throw new UnsupportedOperationException();
    }

    public void remove(InventoryComponent component) {
        throw new UnsupportedOperationException();
    }

    public InventoryComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }

    public abstract void display();
}
