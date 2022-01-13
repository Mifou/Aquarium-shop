package aquarium.shop.basket;

import aquarium.shop.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketServiceImpl implements BasketService {



    @Autowired
    BasketServiceImpl basketService;


    @Override
    public void addProduct(Product product) {
        basketService.addProduct(product);
    }

    @Override
    public void addProduct(Product product, int quantity) {
        basketService.addProduct(product, quantity);
    }

    @Override
    public void removeProduct(Product product) {
        basketService.removeProduct(product);

    }

    @Override
    public void increaseNumberOfProducts(Product product) {
        basketService.increaseNumberOfProducts(product);
    }

    @Override
    public void decreaseNumberOfProducts(Product product) {
        basketService.decreaseNumberOfProducts(product);
    }

    @Override
    public void clearBasket() {
        basketService.clearBasket();
    }

    @Override
    public Basket showBasket() {
        return basketService.showBasket();
    }
}
