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
public class UserDetailsMockTest {

    @MockBean
    private UserService service;

    @Autowired
    private UserController userController;

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllUsers() throws Exception {
        UserDetails user = new UserDetails();

        user.setName("Jasiek");
        user.setPassword("Galasiorka13");
        user.setUserRole("Employee");

        List<UserDetails> users = new ArrayList<>();
        users.add(user);

        when(service.findAll()).thenReturn(users);

        mvc.perform(MockMvcRequestBuilders.get("/users"))
                .andDo(print())
                .andExpect(content().json("[{\"name\":\"Jasiek\",\"password\":\"Galasiorka13\",\"userRole\":\"Employee\"}]"))
                .andExpect(status().isOk());
    }
}
