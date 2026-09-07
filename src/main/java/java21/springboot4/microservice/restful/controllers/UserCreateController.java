package java21.springboot4.microservice.restful.controllers;

import java21.springboot4.microservice.restful.models.UserModel;
import java21.springboot4.microservice.restful.services.UserCreateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java/api/v1/users")
public class UserCreateController {

    private final UserCreateService userService;

    public UserCreateController(UserCreateService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody UserModel userModel) {
        return ResponseEntity.ok(userService.createUser(userModel));
    }
}
