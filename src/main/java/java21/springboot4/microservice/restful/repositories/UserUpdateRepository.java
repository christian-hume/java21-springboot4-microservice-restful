package java21.springboot4.microservice.restful.repositories;

import java21.springboot4.microservice.restful.models.UserModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Christian Hume (DEV)
 * @version 1.0.0
 * @since 2026-08-09
 */
@Repository
public interface UserUpdateRepository extends org.springframework.data.repository.Repository<UserModel, Long> {

    Optional<UserModel> findById(Long idUser);

    UserModel save(UserModel userModel);
}
