package java21.springboot4.microservice.restful.services;

import java21.springboot4.microservice.restful.models.UserModel;
import java21.springboot4.microservice.restful.repositories.UserCreateRepository;
import java21.springboot4.microservice.restful.services.impl.UserCreateServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Christian Hume (DEV)
 * @version 1.0.0
 * @since 2026-08-09
 */
@ExtendWith(MockitoExtension.class)
class UserCreateServiceImplTest {

    @Mock
    private UserCreateRepository userCreateRepository;

    @InjectMocks
    private UserCreateServiceImpl userCreateService;

    @Test
    void whenCreateUserCalled_thenReturnsCreatedUserId() {
        UserModel userModel = new UserModel();
        userModel.setId(1L);
        when(userCreateRepository.save(userModel)).thenReturn(userModel);

        Long userId = userCreateService.createUser(userModel);

        assertEquals(1L, userId);
        verify(userCreateRepository).save(userModel);
    }
}
