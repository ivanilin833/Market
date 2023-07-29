import products.Product;
import workers.Seller;

import java.util.HashMap;
import java.util.Map;

public class Client {
    private final Seller seller;
    private final String name;
    private final String surname;
    private double cash;
    private final Map<Product, Integer> shoppingCart = new HashMap<>();
    private final Map<Product, Integer> purchasedProduct = new HashMap<>();

    public Client(Seller seller, String name, String surname, double cash) {
        this.seller = seller;
        this.name = name;
        this.surname = surname;
        this.cash = cash;
    }

    public void addProductToShoppingCart(Product product, Integer count) {
        int countIn = shoppingCart.getOrDefault(product, 0);
        if (countIn != 0) {
            count += countIn;
        }
        shoppingCart.put(product, count);
    }

    public void buy() {
        shoppingCart.forEach(seller::sell);
        shoppingCart.forEach((p, c) -> this.setCash(this.getCash() - p.getPrice() * c));
        purchasedProduct.putAll(shoppingCart);
        shoppingCart.clear();
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public String getFullName() {
        return this.name + " " + this.surname;
    }

    public String getPurchasedProduct() {
        StringBuilder sb = new StringBuilder();
        sb.append("Вы купили: ");
        purchasedProduct.forEach((p, c) -> sb.append("\n").append(p.getName()).append(" в количестве ").append(c));
        return sb.toString();
    }
}
