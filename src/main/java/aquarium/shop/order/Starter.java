package aquarium.shop.order;

import aquarium.shop.product.Product;
import aquarium.shop.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class Starter {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void startUp() {


        Product gupy = productRepository.save(new Product("animal", "gupy", 7.));
        Product molly = productRepository.save(new Product("animal", "molly", 10.));
        Product root = productRepository.save(new Product("equipment", "root", 30.));

        PurchasedProduct purchasedGupy = new PurchasedProduct(gupy, 6);
        PurchasedProduct purchasedMolly = new PurchasedProduct(molly, 1);
        PurchasedProduct purchasedRoot = new PurchasedProduct(root, 1);

        List<PurchasedProduct> purchasedProductList = new ArrayList<>();
        purchasedProductList.add(purchasedGupy);
        purchasedProductList.add(purchasedMolly);
        purchasedProductList.add(purchasedRoot);

        Address address = new Address("Borownice", "12B", "33-350",
                "Poland", "Piwniczna");
        OrderUser orderUser = new OrderUser("Jan", "Zytkowicz");
        DeliveryDetails deliveryDetails = new DeliveryDetails(address, orderUser, Shipment.DELIVERY);
        OrderDetails order = new OrderDetails(deliveryDetails, PaymentStatus.NOT_PAID, OrderStatus.APPROVED);

        order.setPurchasedProducts(purchasedProductList);
        order.setWholePrice(BigDecimal.valueOf((gupy.getPrice() * 6 + molly.getPrice() + root.getPrice())));

        orderRepository.save(order);


    }


}
