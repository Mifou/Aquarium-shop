package aquarium.shop.basket;

import aquarium.shop.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BasketController {


    @Autowired
    BasketServiceImpl basketService;

    @PostMapping("/basket")
    public void addProduct(@RequestBody Product product) {
        basketService.addProduct(product);
    }

    @GetMapping("/basket")
    public String showBasket(){
        return basketService.showBasket();
    }

    @PostMapping({"/basket/{quantity}"})
    public void addProduct(@PathVariable(value = "quantity") int quantity,
                                                                     @RequestBody Product product) {
        basketService.addProduct(product,quantity);
    }
    @DeleteMapping("/basket")
    public void removeProduct(@RequestBody Product product){
        basketService.removeProduct(product);
    }

    @PostMapping({"/basket/increase"})
    public void increaseNumberOfProducts(@RequestBody Product product) {
        basketService.increaseNumberOfProducts(product);
    }

    @PostMapping({"/basket/decrease"})
    public void decreaseNumberOfProducts(@RequestBody Product product) {
        basketService.decreaseNumberOfProducts(product);
    }
    @PostMapping({"/basket/clear"})
    public void clearBasket(@RequestBody Product product) {
        basketService.clearBasket();
    }






}
