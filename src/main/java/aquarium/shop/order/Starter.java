package aquarium.shop.order;

import aquarium.shop.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.HashMap;

@Component
public class Starter {

    @Autowired
    private OrderRepository orderRepository;

    @PostConstruct
    public void startUp() {
        HashMap<Product, Integer> content = new HashMap<>();
        BigDecimal wholePrice = BigDecimal.valueOf(0);

        Address address = new Address("Borownice", "12B", "33-350",
                "Poland", "Piwniczna");
        OrderUser orderUser = new OrderUser("Jan", "Zytkowicz");
        DeliveryDetails deliveryDetails = new DeliveryDetails(address, orderUser, Shipment.DELIVERY);
        OrderDetails order = new OrderDetails(deliveryDetails, PaymentStatus.NOT_PAID, OrderStatus.APPROVED, wholePrice);

        orderRepository.save(order);

    }


}
