package java21.springboot4.microservice.restful.controllers;

import java21.springboot4.microservice.restful.models.UserModel;
import java21.springboot4.microservice.restful.services.UserUpdateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

/**
 * @author Christian Hume (DEV)
 * @version 1.0.0
 * @since 2026-08-09
 */
@ExtendWith(MockitoExtension.class)
class UserUpdateControllerTest {

    @Mock
    private UserUpdateService userUpdateService;

    @InjectMocks
    private UserUpdateController userUpdateController;

    @Test
    void whenUpdateUserCalled_thenReturnsOk() {
        UserModel userModel = new UserModel();

        var response = userUpdateController.updateUser(1L, userModel);

        assertEquals(200, response.getStatusCode().value());
        verify(userUpdateService).updateUser(1L, userModel);
    }
}
