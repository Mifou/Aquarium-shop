package aquarium.shop;

import aquarium.shop.product.Product;
import aquarium.shop.product.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class ProductControllerMockTest {

    @MockBean
    private ProductService service;

    @Autowired
    private MockMvc mvc;

    private static final List<Product> products = new ArrayList<>();
    Product product = new Product();

    @BeforeEach
    public void seUp() {
        product.setName("Gupy");
        product.setCategory("animal");
        product.setPrice(5d);
        products.add(product);
    }

    @AfterEach
    public void tearDown() {
        products.remove(product);
    }


    @Test
    public void getAllProducts() throws Exception {
        when(service.findAll()).thenReturn(products);

        mvc.perform(MockMvcRequestBuilders.get("/products"))
                .andDo(print())
                .andExpect(content().json("[{'name':'Gupy','category':'animal','price':5.0}]"))
                .andExpect(status().isOk());
    }

    @Test
    public void getProduct() throws Exception {
        when(service.find(anyLong())).thenReturn(product);

        mvc.perform(MockMvcRequestBuilders.get("/products/1"))
                .andDo(print())
                .andExpect(content().json("{'name':'Gupy','category':'animal','price':5.0}"))
                .andExpect(status().isOk());
    }

    @Test
    public void insertTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(product)))
                .andExpect(status().isOk());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}