package java21.springboot4.microservice.restful.services.impl;

import java21.springboot4.microservice.restful.commons.exceptions.NotFoundException;
import java21.springboot4.microservice.restful.models.UserModel;
import java21.springboot4.microservice.restful.repositories.UserReadRepository;
import java21.springboot4.microservice.restful.services.UserReadService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReadServiceImpl implements UserReadService {

    private final UserReadRepository userReadRepository;

    public UserReadServiceImpl(UserReadRepository userReadRepository) {
        this.userReadRepository = userReadRepository;
    }

    @Override
    public List<UserModel> findAllUsers() {
        return userReadRepository.findAll();
    }

    @Override
    public UserModel findUserById(Long idUser) {
        return userReadRepository.findById(idUser)
                .orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND.getReasonPhrase() + ": " + idUser));
    }
}
