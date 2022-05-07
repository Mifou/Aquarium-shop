package aquarium.shop.order;

import javax.persistence.*;

@Entity
@Table(name = "delivery_details")
public class DeliveryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_generator")
    @SequenceGenerator(name = "delivery_generator", sequenceName = "delivery_seq", allocationSize = 50)
    @Column(name = "id")
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private OrderUser orderUser;

    @Column
    @Enumerated(EnumType.STRING)
    private Shipment shipment;

    public DeliveryDetails() {
    }

    public DeliveryDetails(Address address, OrderUser orderUser, Shipment shipment) {
        this.address = address;
        this.orderUser = orderUser;
        this.shipment = shipment;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public OrderUser getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(OrderUser orderUser) {
        this.orderUser = orderUser;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }
}
