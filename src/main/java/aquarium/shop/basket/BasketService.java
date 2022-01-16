package aquarium.shop.basket;

import aquarium.shop.product.Product;

public interface BasketService {

    void addProduct(Product product);
    void addProduct(Product product, int quantity);
    void removeProduct(Product product);
    void increaseNumberOfProducts(Product product);
    void decreaseNumberOfProducts(Product product);
    void clearBasket();
    String showBasket();



}
