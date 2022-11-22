package school.com.web.app.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import school.com.web.app.domain.entity.User;
import school.com.web.app.service.interfaces.UserService;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/signup")
public class UserController {

    private final UserService<User>  userService;


    @PostMapping(value = "/save")
    public boolean saveUser(@RequestBody User user){
        userService.save(user);

        return true;
    }




}
