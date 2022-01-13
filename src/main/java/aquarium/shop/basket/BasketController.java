package aquarium.shop.basket;

import aquarium.shop.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasketController {


    @Autowired
    BasketServiceImpl basketService;

    @PostMapping("/basket")
    public void addProduct(@RequestBody Product product) {
        basketService.addProduct(product);
    }

    @GetMapping("/basket")
    public Basket showBasket(){
        return basketService.showBasket();
    }


}
