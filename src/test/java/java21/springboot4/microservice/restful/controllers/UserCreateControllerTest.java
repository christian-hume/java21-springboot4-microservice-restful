package java21.springboot4.microservice.restful.controllers;

import java21.springboot4.microservice.restful.models.UserModel;
import java21.springboot4.microservice.restful.services.UserCreateService;
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
class UserCreateControllerTest {

    @Mock
    private UserCreateService userCreateService;

    @InjectMocks
    private UserCreateController userCreateController;

    @Test
    void whenCreateUserCalled_thenReturnsCreatedUserId() {
        UserModel userModel = new UserModel();
        when(userCreateService.createUser(userModel)).thenReturn(1L);

        var response = userCreateController.createUser(userModel);

        assertEquals(200, response.getStatusCode().value());
        assertEquals(1L, response.getBody());
        verify(userCreateService).createUser(userModel);
    }
}
