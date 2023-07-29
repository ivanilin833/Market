import filters.Filter;
import filters.FilterByCategory;
import filters.FilterByName;
import filters.FilterByPrice;
import products.Market;
import products.Product;
import products.ProductCategory;
import workers.Manager;
import workers.Seller;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void initMarket() {
        double minPrice = 50;
        double maxPrice = 500;
        Random random = new Random();
        Manager manager = new Manager("Сергей", "Иванов", 100000, Market.getInstance());
        manager.addProduct(Arrays.asList(
                new Product("Хлеб", ProductCategory.FOOD, random.doubles(minPrice, (maxPrice - 1)).findFirst().getAsDouble(), 10),
                new Product("Молоко", ProductCategory.FOOD, random.doubles(minPrice, (maxPrice - 1)).findFirst().getAsDouble(), 5),
                new Product("Колбаса", ProductCategory.FOOD, random.doubles(minPrice, (maxPrice - 1)).findFirst().getAsDouble(), 15),
                new Product("Штаны", ProductCategory.GARMENT, random.doubles(minPrice, (maxPrice - 1)).findFirst().getAsDouble(), 25),
                new Product("Рубашка", ProductCategory.GARMENT, random.doubles(minPrice, (maxPrice - 1)).findFirst().getAsDouble(), 25),
                new Product("Пылесос", ProductCategory.TECHNIC, random.doubles(minPrice, (maxPrice - 1)).findFirst().getAsDouble(), 25),
                new Product("Микроволновка", ProductCategory.TECHNIC, random.doubles(minPrice, (maxPrice - 1)).findFirst().getAsDouble(), 25)
        ));
    }

    public static void main(String[] args) {
        initMarket();
        Scanner scanner = new Scanner(System.in);
        Seller seller = new Seller("Ольга", "Смирнова", 50000, Market.getInstance());
        Client client = new Client(seller, " Михаил", "Петров", 5000);

        boolean isWork = true;

        System.out.println("Добро пожаловать в Ошон " + client.getFullName());
        while (isWork) {
            menu();
            switch (scanner.nextInt()) {
                case 0 -> {
                    System.out.println("Ждем Вас снова !");
                    isWork = false;
                }
                case 1 -> {
                    System.out.println(Market.getInstance().getProductList());
                    System.out.println();
                }
                case 2 -> filterToConsole(scanner);
                case 3 -> {
                    System.out.println(Arrays.toString(ProductCategory.values()));
                    System.out.println();
                }
                case 4 -> productInShoppingCart(scanner, client);
                case 5 -> {
                    client.buy();
                    System.out.println(client.getPurchasedProduct());
                }
            }
        }
    }

    private static void menu() {
        System.out.println("""
                                
                Если желаете увидеть весь ассортимент нажмите 1
                Если хотите отфильтровать ассортимент нажмите 2
                Если хотите увидеть категории товаров нажмите 3
                Если хотите добавить товар в корзину нажмите 4
                Если хотите купить товары в корзине нажмите 5
                Если хотите покинуть магазин нажмите 0
                """);
    }

    private static void filterToConsole(Scanner scanner) {
        Filter filter;
        System.out.println("""
                Если хотите отфильтровать по имени введите 1 затем имя товара
                Если хотите отфильтровать по категории введите 2 затем категорию
                Если хотите отфильтровать по цене введите 3 затем максимальную цену""");

        switch (scanner.nextInt()) {
            case 1 -> {
                filter = new FilterByName();
                System.out.println(filter.filter(Market.getInstance().getProductList(), scanner.next()));
            }
            case 2 -> {
                filter = new FilterByCategory();
                System.out.println(filter.filter(Market.getInstance().getProductList(), ProductCategory.valueOf(scanner.next().toUpperCase())));
            }
            case 3 -> {
                filter = new FilterByPrice();
                System.out.println(filter.filter(Market.getInstance().getProductList(), scanner.nextDouble()));
            }
            default -> System.out.println("Проверьте введеное значение");
        }
    }

    private static void productInShoppingCart(Scanner scanner, Client client) {
        System.out.println("Укажите номер товара и количество");
        int id = scanner.nextInt();
        int count = scanner.nextInt();
        Product product = Market.getInstance().getProductList().stream().filter(p -> p.getId() == id).findFirst().get();
        client.addProductToShoppingCart(product, count);
    }
}
