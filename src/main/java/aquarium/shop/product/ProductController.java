package aquarium.shop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping({"products/{id}"})
    public Product getProduct(@PathVariable(value = "id") long id) {
        return productService.find(id);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productService.insert(product);
    }


    @PostMapping({"products/{id}"})
    public Product updateProduct(@PathVariable(value = "id") long id,
                                                 @RequestBody Product productDetails) {
        Product product = productService.find(id);
        product.setName(productDetails.getName());
        product.setCategory(productDetails.getCategory());
        product.setPrice(productDetails.getPrice());
        productService.insert(product);
        return product;
    }

    @DeleteMapping({"products/{id}"})
    public Product deleteProduct(@PathVariable(value = "id")long id){
        Product product = productService.find(id);
        productService.deleteProduct(id);
        return product;
    }

}




