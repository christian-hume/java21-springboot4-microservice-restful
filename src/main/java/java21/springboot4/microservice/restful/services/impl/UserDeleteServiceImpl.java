package java21.springboot4.microservice.restful.services.impl;

import java21.springboot4.microservice.restful.commons.exceptions.NotFoundException;
import java21.springboot4.microservice.restful.repositories.UserDeleteRepository;
import java21.springboot4.microservice.restful.services.UserDeleteService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserDeleteServiceImpl implements UserDeleteService {

    private final UserDeleteRepository userDeleteRepository;

    public UserDeleteServiceImpl(UserDeleteRepository userDeleteRepository) {
        this.userDeleteRepository = userDeleteRepository;
    }

    @Override
    public void deleteUser(Long idUser) {
        if (!userDeleteRepository.existsById(idUser)) {
            throw new NotFoundException(HttpStatus.NOT_FOUND.getReasonPhrase() + ": " + idUser);
        }
        userDeleteRepository.deleteById(idUser);
    }
}
