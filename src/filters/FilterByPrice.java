package filters;

import products.Product;

import java.util.List;
import java.util.stream.Collectors;

public class FilterByPrice implements Filter<Product, Double> {
    @Override
    public List<Product> filter(List<Product> t, Double value) {
        return t.stream().filter(p -> p.getPrice() < value).collect(Collectors.toList());
    }
}
