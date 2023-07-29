package workers;

import products.Market;
import products.Product;

public class Seller extends Worker {
    private final Market market;

    public Seller(String name, String surname, double salary, Market market) {
        super(name, surname, salary);
        this.market = market;
    }

    public void sell(Product product, int count) {
        product.setCount(product.getCount() - count);
        market.setProfit(product.getPrice() * count);
    }
}
