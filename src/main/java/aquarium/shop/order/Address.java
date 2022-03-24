package aquarium.shop.order;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private String postalcode;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String country;

    public Address() {
    }

    public Address(String street, String number, String postalcode, String country,String city) {
        this.street = street;
        this.number = number;
        this.postalcode = postalcode;
        this.country = country;
        this.city = city;
    }
}

