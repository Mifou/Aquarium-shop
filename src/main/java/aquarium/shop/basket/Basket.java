package aquarium.shop.basket;

import aquarium.shop.product.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Basket {
    private static Basket INSTANCE;

    private Basket() {
    }

    private HashMap<Product, Integer> content = new HashMap<>();
    private double wholePrice;

    public HashMap<Product, Integer> getContent() {
        return content;
    }

    public static Basket getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Basket();
        }
        return INSTANCE;
    }

    public double getWholePrice() {
        return wholePrice;
    }

    public void addProduct(Product product) {
        if (content.containsKey(product)) {
            content.put(product, content.get(product) + 1);
        } else {
            content.put(product, 1);
        }

    }

    public void addProduct(Product product, int quantity) {
        if (content.containsKey(product)) {
            content.put(product, content.get(product) + quantity);
        } else {
            content.put(product, quantity);
        }
    }

    public void removeProduct(Product product) {
        content.remove(product);
    }

    public void increaseNumberOfProducts(Product product) {
        content.replace(product, content.get(product) + 1);
    }

    public void decreaseNumberOfProducts(Product product) {
        content.replace(product, content.get(product) - 1);
    }

    public void clearBasket() {
        content.clear();
    }

    public double calculateBasketPrice() {
        wholePrice = 0;
        Set<Map.Entry<Product, Integer>> contentSet = content.entrySet();
        for (Map.Entry<Product, Integer> entry : contentSet) {
            double oneEntryPrice;
            oneEntryPrice = entry.getKey().getPrice() * entry.getValue();
            wholePrice = wholePrice + oneEntryPrice;
        }
        return wholePrice;
    }

    public Basket showBasket(Basket basket) {
        basket.calculateBasketPrice();
        return basket;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "content=" + content +
                ", wholePrice=" + wholePrice +
                '}';
    }
}





