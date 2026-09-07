package java21.springboot4.microservice.restful.repositories;

import java21.springboot4.microservice.restful.models.UserModel;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDeleteRepository extends org.springframework.data.repository.Repository<UserModel, Long> {

    boolean existsById(Long idUser);

    void deleteById(Long idUser);
}
