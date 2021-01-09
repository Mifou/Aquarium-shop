package aquarium.shop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private ProductController productController;

    @Test
    void contextLoads() throws Exception {
        assertThat(productController).isNotNull();
    }

}
