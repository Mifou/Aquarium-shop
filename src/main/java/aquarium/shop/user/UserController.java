package aquarium.shop.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/users")
    public List<UserDetails> getAllUsers(){
        return userService.findAll();
    }

}
