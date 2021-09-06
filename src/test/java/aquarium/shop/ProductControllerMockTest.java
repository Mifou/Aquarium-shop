package aquarium.shop;

import aquarium.shop.product.Product;
import aquarium.shop.product.ProductController;
import aquarium.shop.product.ProductService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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

    private static List<Product> products = new ArrayList<>();
    Product product = new Product();
    @BeforeEach
    public void seUp(){
        product.setName("Gupy");
        product.setCategory("animal");
        product.setPrice(5d);
        products.add(product);
    }
    @AfterEach
    public void tearDown(){
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
    public void getProduct() throws Exception{

        Product product = new Product();

        product.setName("Dario Dario");
        product.setCategory("animal");
        product.setPrice(8d);

        products.add(product);

        when(service.find(2L)).thenReturn(product);
        Product found = service.find(2L);

        Assertions.assertEquals("Dario Dario", found.getName());
        Assertions.assertEquals("animal", found.getCategory());
        Assertions.assertEquals(8, found.getPrice());

    }

    @Test
    public void insertTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Gupy\", \"category\":\"animal\",\"price\":\"5d\"]"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }




}