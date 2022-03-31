package aquarium.shop.order;

import aquarium.shop.basket.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService  {

    @Autowired
    Basket basket;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void addOrder(OrderDetails orderDetails) {
        orderRepository.save(orderDetails);
    }

    @Override
    public void changeOrderPaymentStatus(int orderId) {
            orderRepository.findAll().get(orderId).setPaymentStatus(PaymentStatus.PAID);
    }

    @Override
    public void changeOrderStatus(int orderId, OrderStatus orderStatus) {
        orderRepository.findAll().get(orderId).setOrderStatus(orderStatus);
    }

    @Override
    public OrderDetails find(long id) {
        return orderRepository.findById(id).get();
    }
}
