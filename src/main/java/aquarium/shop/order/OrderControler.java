package aquarium.shop.order;


import aquarium.shop.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@RestController
public class OrderControler {

    @Autowired
    private OrderRepository repository;

    @GetMapping("/orders")
    public List<OrderDetails> getAllOrders() {
        HashMap<Product, Integer> content = new HashMap<>();
        BigDecimal wholePrice = BigDecimal.valueOf(0);

        Address address = new Address("Borownice", "12B", "33-350",
                "Poland", "Piwniczna");
        OrderUser orderUser = new OrderUser("Jan", "Zytkowicz");
        DeliveryDetails deliveryDetails = new DeliveryDetails(address, orderUser, Shipment.DELIVERY);
        OrderDetails order = new OrderDetails(deliveryDetails, PaymentStatus.PAID, OrderStatus.APPROVED, content, wholePrice);

        repository.save(order);

        return Collections.singletonList(order);
    }

}

