package aquarium.shop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WebMockTest {

    @Autowired
    private ProductController productController;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService service;

    @Test
    public void getAllProducts() throws Exception {
        Product product = new Product();

        product.setName("Gupy");
        product.setCategory("animal");
        product.setPrice(5d);

        List<Product> products = new ArrayList<>();
        products.add(product);

        when(service.findAll().get(anyInt())).thenReturn(product);


        mvc.perform(MockMvcRequestBuilders.get("/product"))
                .andDo(print())
              //  .accept(MediaType.APPLICATION_JSON)
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Gupy"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.category").value("animal"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(5d))
                .andExpect(status().isOk());
    }

}