package java21.springboot4.microservice.restful.repositories;

import java21.springboot4.microservice.restful.models.UserModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserReadRepository extends org.springframework.data.repository.Repository<UserModel, Long> {

    List<UserModel> findAll();

    Optional<UserModel> findById(Long idUser);
}
