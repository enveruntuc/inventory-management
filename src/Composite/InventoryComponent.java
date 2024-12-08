package Composite;

public abstract class InventoryComponent {
    private int id;

    public InventoryComponent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

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
