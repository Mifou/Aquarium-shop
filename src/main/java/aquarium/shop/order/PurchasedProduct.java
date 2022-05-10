package aquarium.shop.order;

import aquarium.shop.product.Product;

import javax.persistence.*;


import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "purchased_product")
public class PurchasedProduct {


    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Integer id;


    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;


    private int quantity;

    public PurchasedProduct() {
    }

    public PurchasedProduct(Product product, int quantity) {
        this.quantity = quantity;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
