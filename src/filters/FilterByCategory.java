package filters;

import products.Product;
import products.ProductCategory;

import java.util.List;
import java.util.stream.Collectors;

public class FilterByCategory implements Filter<Product, ProductCategory> {
    @Override
    public List<Product> filter(List<Product> t, ProductCategory value) {
        return t.stream().filter(p -> p.getCategory().equals(value)).collect(Collectors.toList());
    }
}
