package aquarium.shop.order;

import aquarium.shop.basket.Basket;
import aquarium.shop.product.Product;
import aquarium.shop.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
public class Starter {

    @Autowired
    private OrderService orderService;

    @Autowired
    private Basket basket;

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void startUp() {



        Product gupy = productRepository.save(new Product("animal", "gupy", 7.));
        Product molly = productRepository.save(new Product("animal", "molly", 10.));
        Product root = productRepository.save(new Product("equipment", "root", 30.));

        basket.addProduct(gupy, 6);
        basket.addProduct(molly);
        basket.addProduct(root);

        Address address = new Address("Borownice", "12B", "33-350",
                "Poland", "Piwniczna");
        OrderUser orderUser = new OrderUser("Jan", "Zytkowicz");
        DeliveryDetails deliveryDetails = new DeliveryDetails(address, orderUser, Shipment.DELIVERY);
        OrderDetails order = new OrderDetails(deliveryDetails, PaymentStatus.NOT_PAID, OrderStatus.APPROVED );

        orderService.addOrder(order);


    }


}
