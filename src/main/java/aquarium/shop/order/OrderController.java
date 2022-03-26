package aquarium.shop.order;


import aquarium.shop.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostConstruct
    public List<OrderDetails> getAllOrders() {
        HashMap<Product, Integer> content = new HashMap<>();
        BigDecimal wholePrice = BigDecimal.valueOf(0);

        Address address = new Address("Borownice", "12B", "33-350",
                "Poland", "Piwniczna");
        OrderUser orderUser = new OrderUser("Jan", "Zytkowicz");
        DeliveryDetails deliveryDetails = new DeliveryDetails(address, orderUser, Shipment.DELIVERY);
        OrderDetails order = new OrderDetails(deliveryDetails, PaymentStatus.NOT_PAID, OrderStatus.APPROVED, content, wholePrice);

        orderRepository.save(order);

        return Collections.singletonList(order);
    }

    @PostMapping("/order")
    public void addOrder(OrderDetails orderDetails) {
        orderRepository.save(orderDetails);
    }
    @PatchMapping("/order/payment")
    public void changeOrderPaymentStatus(int orderId) {
        orderRepository.findAll().get(orderId).setPaymentStatus(PaymentStatus.PAID);
    }

    @PatchMapping("/order/status")
    public void changeOrderStatus(int orderId, OrderStatus orderStatus) {
        orderRepository.findAll().get(orderId).setOrderStatus(orderStatus);
    }

}

