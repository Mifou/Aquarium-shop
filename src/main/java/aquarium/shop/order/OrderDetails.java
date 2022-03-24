package aquarium.shop.order;

import aquarium.shop.product.Product;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashMap;

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deliveryDetails_id", referencedColumnName = "id")
    private DeliveryDetails deliveryDetails;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private HashMap<Product, Integer> content = new HashMap<>();
    private BigDecimal wholePrice = BigDecimal.valueOf(0);

    public OrderDetails() {
    }

    public OrderDetails(DeliveryDetails deliveryDetails, PaymentStatus paymentStatus,
                        OrderStatus orderStatus, HashMap<Product, Integer> content, BigDecimal wholePrice) {
        this.deliveryDetails = deliveryDetails;
        this.paymentStatus = paymentStatus;
        this.orderStatus = orderStatus;
        this.content = content;
        this.wholePrice = wholePrice;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }


    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setPaymentStatus(PaymentStatus i) {
        this.paymentStatus = paymentStatus;
    }
}
