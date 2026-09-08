package java21.springboot4.microservice.restful.services;

import java21.springboot4.microservice.restful.models.UserModel;

import java.util.List;

/**
 * @author Christian Hume (DEV)
 * @version 1.0.0
 * @since 2026-08-09
 */
public interface UserReadService {

    List<UserModel> findAllUsers();

    UserModel findUserById(Long idUser);
}
