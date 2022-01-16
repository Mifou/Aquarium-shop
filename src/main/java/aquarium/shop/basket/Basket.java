package aquarium.shop.basket;

import aquarium.shop.product.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;

@Component
public class Basket {

    private HashMap<Product, Integer> content = new HashMap<>();
    private BigDecimal wholePrice = BigDecimal.valueOf(0);

    public HashMap<Product, Integer> getContent() {
        return content;
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
        wholePrice = wholePrice.subtract(BigDecimal.valueOf(product.getPrice()*content.get(product)));
        content.remove(product);

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

    public String showBasket() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Basket{" +
                "content=" + content +
                ", wholePrice=" + wholePrice +
                '}';
    }
}





