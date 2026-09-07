package java21.springboot4.microservice.restful.controllers;

import java21.springboot4.microservice.restful.models.UserModel;
import java21.springboot4.microservice.restful.services.UserUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java/api/v1/users")
public class UserUpdateController {

    private final UserUpdateService userService;

    public UserUpdateController(UserUpdateService userService) {
        this.userService = userService;
    }

    @PutMapping("/{id_user}")
    public ResponseEntity<Void> updateUser(
            @PathVariable("id_user") Long idUser,
            @RequestBody UserModel userModel) {
        userService.updateUser(idUser, userModel);
        return ResponseEntity.ok().build();
    }
}
