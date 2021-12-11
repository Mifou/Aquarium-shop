package aquarium.shop;

import aquarium.shop.basket.Basket;
import aquarium.shop.product.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasketTests {

    Product product = new Product();
    Basket basket = Basket.getInstance();
    Product product2 = new Product();

    @BeforeEach
    public void seUp() {
        product.setName("Gupy");
        product.setCategory("animal");
        product.setPrice(5d);

        product2.setName("Dario Dario");
        product2.setCategory("animal");
        product2.setPrice(8d);
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
        basket.increaseNumberOfProducts(product);
        Assertions.assertEquals(basket.getContent().get(product), 2);
    }

    @Test
    public void decreaseProductQuantity() {
        basket.addProduct(product, 4);
        basket.decreaseNumberOfProducts(product);
        Assertions.assertEquals(basket.getContent().get(product), 3);
    }

    @Test
    public void clearBasketTest() {
        basket.addProduct(product, 4);
        basket.clearBasket();
        Assertions.assertTrue(basket.getContent().isEmpty());
    }

    @Test
    public void calculateBasketPriceTest(){
        basket.addProduct(product, 5);
        basket.addProduct(product2, 1);
        Assertions.assertEquals(33, basket.calculateBasketPrice());
        Assertions.assertNotEquals(32, basket.calculateBasketPrice(), 0.0);
        System.out.println(basket.toString());
    }

    @Test
    public void ShowBasketTest(){
        basket.addProduct(product, 2);
        basket.addProduct(product2, 1);
        Assertions.assertTrue(basket.showBasket(basket).getContent().containsKey(product)
                &&basket.showBasket(basket).getContent().containsKey(product2));
        Assertions.assertEquals(basket.getContent().get(product),2);
        Assertions.assertEquals(basket.getContent().get(product2),1);
        Assertions.assertEquals(basket.calculateBasketPrice(),18);
        Assertions.assertNotEquals(basket.calculateBasketPrice(),10);

    }

}
