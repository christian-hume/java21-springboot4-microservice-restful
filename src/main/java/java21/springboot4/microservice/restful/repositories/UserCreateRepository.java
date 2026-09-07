package java21.springboot4.microservice.restful.repositories;

import java21.springboot4.microservice.restful.models.UserModel;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCreateRepository extends org.springframework.data.repository.Repository<UserModel, Long> {

    UserModel save(UserModel userModel);
}
