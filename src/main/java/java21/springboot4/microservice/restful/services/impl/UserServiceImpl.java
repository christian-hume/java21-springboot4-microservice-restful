package com.java17.springboot3.microservice.restful.services.impl;

import com.java17.springboot3.microservice.restful.commons.exceptions.NotFoundException;
import com.java17.springboot3.microservice.restful.models.UserModel;
import com.java17.springboot3.microservice.restful.repositories.UserRepository;
import com.java17.springboot3.microservice.restful.services.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Christian Hume (DEVs)
 * @version 1.0.0
 * @since 2025-10-01
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long createUser(UserModel userCreate) {
        UserModel userNew = userRepository.save(userCreate);
        return userNew.getId();
    }

    @Override
    public List<UserModel> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserModel findUserById(Long idUser) {
        return userRepository.findById(idUser)
                .orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND.getReasonPhrase() + ": " + idUser));
    }

    @Override
    public void updateUser(Long idUser, UserModel userUpdate) {
        UserModel existingUser = userRepository.findById(idUser)
                .orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND.getReasonPhrase() + ": " + idUser));
        existingUser.setFirstName(userUpdate.getFirstName());
        existingUser.setEmail(userUpdate.getEmail());
        existingUser.setOccupation(userUpdate.getOccupation());
        userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long idUser) {
        if (!userRepository.existsById(idUser)) {
            throw new NotFoundException(HttpStatus.NOT_FOUND.getReasonPhrase() + ": " + idUser);
        }
        userRepository.deleteById(idUser);
    }

}
