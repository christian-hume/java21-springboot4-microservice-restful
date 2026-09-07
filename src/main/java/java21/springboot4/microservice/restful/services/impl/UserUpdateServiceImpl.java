package java21.springboot4.microservice.restful.services.impl;

import java21.springboot4.microservice.restful.commons.exceptions.NotFoundException;
import java21.springboot4.microservice.restful.models.UserModel;
import java21.springboot4.microservice.restful.repositories.UserUpdateRepository;
import java21.springboot4.microservice.restful.services.UserUpdateService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserUpdateServiceImpl implements UserUpdateService {

    private final UserUpdateRepository userUpdateRepository;

    public UserUpdateServiceImpl(UserUpdateRepository userUpdateRepository) {
        this.userUpdateRepository = userUpdateRepository;
    }

    @Override
    public void updateUser(Long idUser, UserModel userUpdate) {
        UserModel existingUser = userUpdateRepository.findById(idUser)
                .orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND.getReasonPhrase() + ": " + idUser));
        existingUser.setFirstName(userUpdate.getFirstName());
        existingUser.setEmail(userUpdate.getEmail());
        existingUser.setOccupation(userUpdate.getOccupation());
        userUpdateRepository.save(existingUser);
    }
}
