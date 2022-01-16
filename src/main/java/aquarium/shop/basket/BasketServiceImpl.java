package aquarium.shop.basket;

import aquarium.shop.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    Basket basket;


    @Override
    public void addProduct(Product product) {
        basket.addProduct(product);
    }

    @Override
    public void addProduct(Product product, int quantity) {
        basket.addProduct(product, quantity);
    }

    @Override
    public void removeProduct(Product product) {
        basket.removeProduct(product);

    }

    @Override
    public void increaseNumberOfProducts(Product product) {
        basket.increaseNumberOfProducts(product);
    }

    @Override
    public void decreaseNumberOfProducts(Product product) {
        basket.decreaseNumberOfProducts(product);
    }

    @Override
    public void clearBasket() {
        basket.clearBasket();
    }

    @Override
    public Basket showBasket() {
        return basket.showBasket();
    }
}
