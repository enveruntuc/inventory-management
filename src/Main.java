import Composite.Category;
import Composite.Product;

import java.util.PrimitiveIterator;

public class Main {
    public static void main(String[] args) {
       Product banana =  new Product("banana",50,1);
       Product apple = new Product("apple",50,2);
       Product orange = new Product("orange",50,3);

        Category fruit = new Category("Fruit");
        fruit.add(banana);
        fruit.add(apple);
        fruit.add(orange);

        fruit.display();

    }
}