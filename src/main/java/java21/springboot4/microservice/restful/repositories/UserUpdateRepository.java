package java21.springboot4.microservice.restful.repositories;

import java21.springboot4.microservice.restful.models.UserModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserUpdateRepository extends org.springframework.data.repository.Repository<UserModel, Long> {

    Optional<UserModel> findById(Long idUser);

    UserModel save(UserModel userModel);
}
