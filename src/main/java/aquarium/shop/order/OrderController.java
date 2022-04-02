package aquarium.shop.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public void addOrder(@RequestBody OrderDetails orderDetails) {
        orderService.addOrder(orderDetails);
    }

    @PutMapping("/order/payment")
    public void changeOrderPaymentStatus(@RequestBody Long id ) {
        orderService.find(id).setPaymentStatus(PaymentStatus.PAID);
    }

    @PutMapping("/order/status")
    public void changeOrderStatus(@RequestBody OrderDetails orderDetails, OrderStatus orderStatus) {
        orderService.find(orderDetails.getId()).setOrderStatus(orderStatus);
    }

}

