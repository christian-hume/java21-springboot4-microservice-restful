package java21.springboot4.microservice.restful.repositories;

import java21.springboot4.microservice.restful.models.UserModel;
import org.springframework.stereotype.Repository;

/**
 * @author Christian Hume (DEV)
 * @version 1.0.0
 * @since 2026-08-09
 */
@Repository
public interface UserDeleteRepository extends org.springframework.data.repository.Repository<UserModel, Long> {

    boolean existsById(Long idUser);

    void deleteById(Long idUser);
}
