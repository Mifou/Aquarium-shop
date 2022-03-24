package aquarium.shop.order;

public interface OrderService {

    void addOrder(OrderDetails orderDetails);
    void changeOrderPaymentStatus(int orderId);
    void changeOrderStatus(int orderId,OrderStatus orderStatus);

}
