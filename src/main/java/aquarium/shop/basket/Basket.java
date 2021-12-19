package aquarium.shop.basket;

import aquarium.shop.product.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Basket {
    private static Basket INSTANCE;

    private Basket() {
    }

    private HashMap<Product, Integer> content = new HashMap<>();
    private BigDecimal wholePrice = BigDecimal.valueOf(0);

    public HashMap<Product, Integer> getContent() {
        return content;
    }

    public static Basket getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Basket();
        }
        return INSTANCE;
    }

    public BigDecimal getWholePrice() {
        return wholePrice;
    }

    public void addProduct(Product product) {
        if (content.containsKey(product)) {
            content.put(product, content.get(product) + 1);
        } else {
            content.put(product, 1);
        }
        wholePrice = wholePrice.add(BigDecimal.valueOf(product.getPrice()));

    }

    public void addProduct(Product product, int quantity) {
        if (content.containsKey(product)) {
            content.put(product, content.get(product) + quantity);
        } else {
            content.put(product, quantity);
        }
        wholePrice = wholePrice.add(BigDecimal.valueOf(product.getPrice()*quantity));
    }

    public void removeProduct(Product product) {
        content.remove(product);
        wholePrice = wholePrice.subtract(BigDecimal.valueOf(product.getPrice()));
    }

    public void increaseNumberOfProducts(Product product) {
        content.replace(product, content.get(product) + 1);
        wholePrice = wholePrice.add(BigDecimal.valueOf(product.getPrice()));
    }

    public void decreaseNumberOfProducts(Product product) {
        content.replace(product, content.get(product) - 1);
        wholePrice = wholePrice.subtract(BigDecimal.valueOf(product.getPrice()));
    }

    public void clearBasket() {
        content.clear();
        wholePrice = BigDecimal.valueOf(0);
    }

    public BigDecimal calculateBasketPrice() {

        wholePrice = BigDecimal.valueOf(0);
        Set<Map.Entry<Product, Integer>> contentSet = content.entrySet();
        for (Map.Entry<Product, Integer> entry : contentSet) {
            BigDecimal oneEntryPrice;
            oneEntryPrice = BigDecimal.valueOf(entry.getKey().getPrice() * entry.getValue()) ;
            wholePrice = wholePrice.add(oneEntryPrice);
        }
        return wholePrice;
    }

    public Basket showBasket(Basket basket) {
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





