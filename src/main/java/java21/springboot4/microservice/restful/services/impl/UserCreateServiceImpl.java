package java21.springboot4.microservice.restful.services.impl;

import java21.springboot4.microservice.restful.models.UserModel;
import java21.springboot4.microservice.restful.repositories.UserCreateRepository;
import java21.springboot4.microservice.restful.services.UserCreateService;
import org.springframework.stereotype.Service;

/**
 * @author Christian Hume (DEV)
 * @version 1.0.0
 * @since 2026-08-09
 */
@Service
public class UserCreateServiceImpl implements UserCreateService {

    private final UserCreateRepository userCreateRepository;

    public UserCreateServiceImpl(UserCreateRepository userCreateRepository) {
        this.userCreateRepository = userCreateRepository;
    }

    @Override
    public Long createUser(UserModel userModel) {
        return userCreateRepository.save(userModel).getId();
    }
}
