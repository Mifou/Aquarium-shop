package aquarium.shop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<Product> getProduct(@PathVariable(value = "id") long id) {
        return ResponseEntity.ok().body(productService.find(id));
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productService.insert(product);
    }


    @PostMapping({"products/{id}"})
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") long id,
                                                 @RequestBody Product productDetails) {
        Product product = productService.find(id);
        product.setName(productDetails.getName());
        product.setCategory(productDetails.getCategory());
        product.setPrice(productDetails.getPrice());
        productService.insert(product);
        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping({"products/{id}"})
    public ResponseEntity deleteProduct(@PathVariable(value = "id")long id){
        Product product = productService.find(id);
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();

    }

}




