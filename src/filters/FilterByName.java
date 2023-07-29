package filters;

import products.Product;

import java.util.List;
import java.util.stream.Collectors;

public class FilterByName implements Filter<Product, String> {
    @Override
    public List<Product> filter(List<Product> t, String value) {
        return t.stream().filter(p -> p.getName().toLowerCase().contains(value.toLowerCase())).collect(Collectors.toList());
    }
}
