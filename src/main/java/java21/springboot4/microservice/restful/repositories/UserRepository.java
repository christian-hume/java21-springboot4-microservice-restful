package com.java17.springboot3.microservice.restful.repositories;

import com.java17.springboot3.microservice.restful.models.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Christian Hume (DEVs)
 * @version 1.0.0
 * @since 2025-10-01
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

}
