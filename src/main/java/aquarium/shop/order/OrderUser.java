package aquarium.shop.order;

import javax.persistence.*;

@Entity
@Table(name = "order_user")
public class OrderUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String name;

    private String surname;

    public OrderUser() {
    }

    public OrderUser(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
