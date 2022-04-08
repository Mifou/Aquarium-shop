package aquarium.shop.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public void addOrder(@RequestBody OrderDetails orderDetails) {
        orderService.addOrder(orderDetails);
    }

    @PutMapping("/order/payment")
    public void changeOrderPaymentStatus(@RequestBody Map<String, Object> body) {
        OrderDetails order = orderService.find((Integer) body.get("id"));
        order.setPaymentStatus(PaymentStatus.PAID);
        orderService.addOrder(order);
    }

    @PutMapping("/order/status")
    public void changeOrderStatus(@RequestBody Map<String, Object> body) {
        OrderDetails order = orderService.find((Integer) body.get("id"));
        String orderStatus = (String) body.get("status");
        order.setOrderStatus(OrderStatus.valueOf(orderStatus));
        orderService.addOrder(order);
    }

}

