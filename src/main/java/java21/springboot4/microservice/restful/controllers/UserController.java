package com.java17.springboot3.microservice.restful.controllers;

import com.java17.springboot3.microservice.restful.models.UserModel;
import com.java17.springboot3.microservice.restful.services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Christian Hume (DEVs)
 * @version 1.0.0
 * @since 2025-10-01
 */
@RestController
@RequestMapping("/java/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<Long> createUser(@RequestBody UserModel userModel) {
        return ResponseEntity.ok(userService.createUser(userModel));
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserModel>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping(value = "/users/{id_user}")
    public ResponseEntity<UserModel> findUserById(@PathVariable("id_user") Long idUser) {
        return ResponseEntity.ok(userService.findUserById(idUser));
    }

    @PutMapping(value = "/users/{id_user}")
    public ResponseEntity<Void> updateUser(@PathVariable("id_user") Long idUser, @RequestBody UserModel userModel) {
        userService.updateUser(idUser, userModel);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/users/{id_user}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id_user") Long idUser) {
        userService.deleteUser(idUser);
        return ResponseEntity.ok().build();
    }

}
