package aquarium.shop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerMockTest {

    @MockBean
    private ProductService service;

    @Autowired
    private ProductController productController;

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllProducts() throws Exception {
        Product product = new Product();

        product.setName("Gupy");
        product.setCategory("animal");
        product.setPrice(5d);

        List<Product> products = new ArrayList<>();
        products.add(product);

        when(service.findAll()).thenReturn(products);

        mvc.perform(MockMvcRequestBuilders.get("/products"))
                .andDo(print())
                .andExpect(content().json("[{'name':'Gupy','category':'animal','price':5.0}]"))
                .andExpect(status().isOk());
    }

}