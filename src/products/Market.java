package products;

import java.util.ArrayList;
import java.util.List;

public class Market {

    private static Market market;
    private final List<Product> productList = new ArrayList<>();
    private double profit;

    private Market() {
    }

    public static Market getInstance() {
        if (market == null) market = new Market();
        return market;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public List<Product> getProductList() {
        return productList;
    }

}
