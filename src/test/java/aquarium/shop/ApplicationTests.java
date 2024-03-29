package aquarium.shop;

import aquarium.shop.product.ProductController;
import aquarium.shop.user.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private ProductController productController;

    @Autowired
    private UserController userController;

    @Test
    void contextLoads() {
        assertThat(productController).isNotNull();
        assertThat(userController).isNotNull();
    }

}
