package java21.springboot4.microservice.restful.controllers;

import java21.springboot4.microservice.restful.services.UserDeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Christian Hume (DEV)
 * @version 1.0.0
 * @since 2026-08-09
 */
@RestController
@RequestMapping("/java/api/v1/users")
public class UserDeleteController {

    private final UserDeleteService userService;

    public UserDeleteController(UserDeleteService userService) {
        this.userService = userService;
    }

    @DeleteMapping("/{id_user}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id_user") Long idUser) {
        userService.deleteUser(idUser);
        return ResponseEntity.ok().build();
    }
}
