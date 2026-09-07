package java21.springboot4.microservice.restful.services;

import java21.springboot4.microservice.restful.models.UserModel;

public interface UserUpdateService {

    void updateUser(Long idUser, UserModel userModel);
}
