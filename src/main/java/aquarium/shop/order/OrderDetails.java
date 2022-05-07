package aquarium.shop.order;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_generator")
    @SequenceGenerator(name = "order_generator", sequenceName = "order_seq", allocationSize = 50)
    @Column(name = "id")
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deliveryDetails_id", referencedColumnName = "id")
    private DeliveryDetails deliveryDetails;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public long getId() {
        return id;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private List<PurchasedProduct> purchasedProducts;


    private BigDecimal wholePrice;

    public OrderDetails() {
    }

    public OrderDetails(DeliveryDetails deliveryDetails, PaymentStatus paymentStatus,
                        OrderStatus orderStatus) {
        this.deliveryDetails = deliveryDetails;
        this.paymentStatus = paymentStatus;
        this.orderStatus = orderStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setDeliveryDetails(DeliveryDetails deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
    }

    public DeliveryDetails getDeliveryDetails() {
        return deliveryDetails;
    }

    public List<PurchasedProduct> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(List<PurchasedProduct> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    public BigDecimal getWholePrice() {
        return wholePrice;
    }

    public void setWholePrice(BigDecimal wholePrice) {
        this.wholePrice = wholePrice;
    }
}
