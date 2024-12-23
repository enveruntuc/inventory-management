package Composite;

import java.util.ArrayList;
import java.util.List;

public class Category extends InventoryComponent {
    private String name;
    private List<InventoryComponent> components = new ArrayList<>();

    public Category(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public void add(InventoryComponent component) {
        components.add(component);
    }

    @Override
    public void remove(InventoryComponent component) {
        components.remove(component);
    }

    @Override
    public InventoryComponent getChild(int index) {
        return components.get(index);
    }

    @Override
    public void display() {
        System.out.println("Category: " + name);
        if(!components.isEmpty()) {
            for (InventoryComponent component : components) {
                component.display();
            }
        }
    }
}
