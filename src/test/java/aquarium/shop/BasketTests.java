package aquarium.shop;

import aquarium.shop.basket.Basket;
import aquarium.shop.product.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasketTests {

    Product product = new Product();
    Basket basket = new Basket();

    @BeforeEach
    public void seUp() {
        product.setName("Gupy");
        product.setCategory("animal");
        product.setPrice(5d);
    }

    @AfterEach
    public void tearDown() {
        basket.getContent().clear();
    }

    @Test
    public void addProductTest() {
        basket.addProduct(product);
        Assertions.assertFalse(basket.getContent().isEmpty());
    }

    @Test
    public void removeProductTest() {
        basket.addProduct(product);
        basket.removeProduct(product);
        Assertions.assertFalse(basket.getContent().containsKey(product));
    }

    @Test
    public void increaseProductQuantity() {
        basket.addProduct(product);
        basket.increaseNumberOfProducts(product, 4);
        Assertions.assertEquals(basket.getContent().get(product), 5);
    }

    @Test
    public void decreaseProductQuantity() {
        basket.addProduct(product, 4);
        basket.decreaseNumberOfProducts(product, 2);
        Assertions.assertEquals(basket.getContent().get(product), 2);
    }

    @Test
    public void clearBasketTest() {
        basket.addProduct(product, 4);
        basket.clearBasket();
        Assertions.assertTrue(basket.getContent().isEmpty());
    }
}
