package aquarium.shop.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public void addOrder(OrderDetails orderDetails) {
        orderService.addOrder(orderDetails);
    }

    @PatchMapping("/order/payment")
    public void changeOrderPaymentStatus(@RequestBody OrderDetails orderDetails ) {
        orderService.find(orderDetails.getId()).setPaymentStatus(PaymentStatus.PAID);
    }

    @PatchMapping("/order/status")
    public void changeOrderStatus(@RequestBody OrderDetails orderDetails, OrderStatus orderStatus) {
        orderService.find(orderDetails.getId()).setOrderStatus(orderStatus);
    }

}

