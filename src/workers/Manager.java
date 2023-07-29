package workers;

import products.Market;
import products.Product;

import java.util.List;

public class Manager extends Worker {
    private final Market market;

    public Manager(String name, String surname, double salary, Market market) {
        super(name, surname, salary);
        this.market = market;
    }

    public void addProduct(List<Product> list) {
        market.getProductList().addAll(list);
    }

    public void deleteProduct(String name) {
        market.getProductList().removeIf(product -> product.getName().equals(name));
    }
}
