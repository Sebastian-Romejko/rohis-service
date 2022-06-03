package rohis.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public boolean login(@RequestBody User user) {
        return userService.getByEmail(user.getEmail()).getPassword().equals(user.getPassword());
    }

    @PostMapping("/addUser")
    public boolean addUser(@RequestBody User user) {
        try {
            userService.addUser(user);
            return true;
        } catch(Exception exc) {
            return false;
        }

    }
}
