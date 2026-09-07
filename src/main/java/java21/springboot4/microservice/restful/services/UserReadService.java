package java21.springboot4.microservice.restful.services;

import java21.springboot4.microservice.restful.models.UserModel;

import java.util.List;

public interface UserReadService {

    List<UserModel> findAllUsers();

    UserModel findUserById(Long idUser);
}
