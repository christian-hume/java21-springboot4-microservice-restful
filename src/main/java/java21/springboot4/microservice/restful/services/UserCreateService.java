package java21.springboot4.microservice.restful.services;

import java21.springboot4.microservice.restful.models.UserModel;

/**
 * @author Christian Hume (DEV)
 * @version 1.0.0
 * @since 2026-08-09
 */
public interface UserCreateService {

    Long createUser(UserModel userModel);
}
