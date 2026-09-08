package java21.springboot4.microservice.restful.controllers;

import java21.springboot4.microservice.restful.services.UserDeleteService;
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
class UserDeleteControllerTest {

    @Mock
    private UserDeleteService userDeleteService;

    @InjectMocks
    private UserDeleteController userDeleteController;

    @Test
    void whenDeleteUserCalled_thenReturnsOk() {
        var response = userDeleteController.deleteUser(1L);

        assertEquals(200, response.getStatusCode().value());
        verify(userDeleteService).deleteUser(1L);
    }
}
