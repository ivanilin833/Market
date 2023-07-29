package products;

public class Product {
    private static int number = 0;
    protected final ProductCategory category;
    protected int id;
    protected String name;
    protected double price;
    protected int count;
    protected String description;

    public Product(String name, ProductCategory category, double price, int count) {
        this.id = number++;
        this.name = name;
        this.category = category;
        this.price = price;
        this.count = count;
    }

    //DRY
    private static void checkIsNull(Number value) {
        if (value.intValue() < 0) {
            throw new IllegalArgumentException("Check value");
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        checkIsNull(count);
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        checkIsNull(price);
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductCategory getCategory() {
        return category;
    }

    @Override
    public String toString() {
        if (description != null) {
            return "\nProduct{" +
                    "id='" + id + '\'' +
                    "name='" + name + '\'' +
                    ", category=" + category +
                    ", price=" + price +
                    ", count=" + count +
                    ", description='" + description + '\'' +
                    "}";
        } else {
            return "\nProduct{" +
                    "id='" + id + '\'' +
                    "name='" + name + '\'' +
                    ", category=" + category +
                    ", price=" + price +
                    ", count=" + count +
                    "}";
        }

    }

    public int getId() {
        return id;
    }
}
