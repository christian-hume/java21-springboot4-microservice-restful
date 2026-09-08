package java21.springboot4.microservice.restful.controllers;

import java21.springboot4.microservice.restful.models.UserModel;
import java21.springboot4.microservice.restful.services.UserReadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Christian Hume (DEV)
 * @version 1.0.0
 * @since 2026-08-09
 */
@RestController
@RequestMapping("/java/api/v1/users")
public class UserReadController {

    private final UserReadService userService;

    public UserReadController(UserReadService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/{id_user}")
    public ResponseEntity<UserModel> findUserById(@PathVariable("id_user") Long idUser) {
        return ResponseEntity.ok(userService.findUserById(idUser));
    }
}
