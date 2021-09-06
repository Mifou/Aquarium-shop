package aquarium.shop.product;

import java.util.List;

public interface ProductService {
    List<Product>findAll();

    Product insert(Product product);
    Product find(Long id);
    void updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
