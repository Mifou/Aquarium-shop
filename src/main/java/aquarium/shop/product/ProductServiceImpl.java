package aquarium.shop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return (List<Product>)repository.findAll();
    }

    @Override
    public Product insert(Product product) {
        return repository.save(product);
    }

    @Override
    public Product find(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void updateProduct(Long id, Product product) {
        Product productFromDb = repository.findById(id).get();
        System.out.println(productFromDb.toString());
        productFromDb.setName(product.getName());
        productFromDb.setPrice(product.getPrice());
        productFromDb.setCategory(product.getCategory());
        repository.save(productFromDb);
    }

    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
