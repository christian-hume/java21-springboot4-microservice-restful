package java21.springboot4.microservice.restful.repositories;

import jakarta.persistence.EntityManager;
import java21.springboot4.microservice.restful.models.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Christian Hume (DEV)
 * @version 1.0.0
 * @since 2026-08-09
 */
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserCreateRepository userCreateRepository;

    @Autowired
    private UserReadRepository userReadRepository;

    @Autowired
    private UserUpdateRepository userUpdateRepository;

    @Autowired
    private UserDeleteRepository userDeleteRepository;

    @BeforeEach
    void cleanDatabase() {
        entityManager.createQuery("delete from UserModel").executeUpdate();
        entityManager.flush();
    }

    @Test
    void whenSaveUserCalled_thenPersistsUser() {
        UserModel userModel = createUser("Create");

        UserModel savedUser = userCreateRepository.save(userModel);
        entityManager.flush();

        assertNotNull(savedUser.getId());
    }

    @Test
    void whenFindAllUsersCalled_thenReturnsPersistedUsers() {
        UserModel userModel = createUser("Read");
        entityManager.persist(userModel);
        entityManager.flush();
        entityManager.clear();

        var users = userReadRepository.findAll();

        assertEquals(1, users.size());
        assertEquals("Read", users.getFirst().getFirstName());
    }

    @Test
    void whenFindByIdCalledWithExistingId_thenReturnsUser() {
        UserModel userModel = createUser("Find");
        entityManager.persist(userModel);
        entityManager.flush();
        entityManager.clear();

        Optional<UserModel> result = userReadRepository.findById(userModel.getId());

        assertTrue(result.isPresent());
        assertEquals("Find", result.get().getFirstName());
    }

    @Test
    void whenUpdateUserCalled_thenPersistsChangedUser() {
        UserModel userModel = createUser("Before");
        entityManager.persist(userModel);
        entityManager.flush();
        entityManager.clear();

        UserModel existingUser = userUpdateRepository.findById(userModel.getId()).orElseThrow();
        existingUser.setFirstName("After");
        userUpdateRepository.save(existingUser);
        entityManager.flush();
        entityManager.clear();

        UserModel updatedUser = userUpdateRepository.findById(userModel.getId()).orElseThrow();
        assertEquals("After", updatedUser.getFirstName());
    }

    @Test
    void whenDeleteUserCalledWithExistingId_thenRemovesUser() {
        UserModel userModel = createUser("Delete");
        entityManager.persist(userModel);
        entityManager.flush();

        assertTrue(userDeleteRepository.existsById(userModel.getId()));
        userDeleteRepository.deleteById(userModel.getId());
        entityManager.flush();

        assertFalse(userDeleteRepository.existsById(userModel.getId()));
    }

    private UserModel createUser(String firstName) {
        UserModel userModel = new UserModel();
        userModel.setFirstName(firstName);
        userModel.setLastName("Test");
        userModel.setNationality("Testland");
        userModel.setOccupation("Tester");
        userModel.setKnownFor("Automated tests");
        userModel.setEmail(firstName.toLowerCase() + "@example.com");
        userModel.setPhone("555-0100");
        return userModel;
    }
}
