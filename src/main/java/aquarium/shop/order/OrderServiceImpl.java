package aquarium.shop.order;

import aquarium.shop.basket.Basket;
import aquarium.shop.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    Basket basket;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void addOrder(OrderDetails orderDetails) {
        List<PurchasedProduct> purchasedProductList = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : basket.showBasket().getContent().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            PurchasedProduct purchasedProduct = new PurchasedProduct(product, quantity);
            purchasedProductList.add(purchasedProduct);
        }

        orderDetails.setWholePrice(basket.getWholePrice());
        orderDetails.setPurchasedProducts(purchasedProductList);
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
