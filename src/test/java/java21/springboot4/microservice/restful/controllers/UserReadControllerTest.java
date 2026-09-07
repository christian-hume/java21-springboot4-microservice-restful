package java21.springboot4.microservice.restful.controllers;

import java21.springboot4.microservice.restful.models.UserModel;
import java21.springboot4.microservice.restful.services.UserReadService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserReadControllerTest {

    @Mock
    private UserReadService userReadService;

    @InjectMocks
    private UserReadController userReadController;

    @Test
    void whenFindAllUsersCalled_thenReturnsUsers() {
        List<UserModel> users = List.of(new UserModel());
        when(userReadService.findAllUsers()).thenReturn(users);

        var response = userReadController.findAllUsers();

        assertEquals(200, response.getStatusCode().value());
        assertEquals(users, response.getBody());
        verify(userReadService).findAllUsers();
    }

    @Test
    void whenFindUserByIdCalled_thenReturnsUser() {
        UserModel userModel = new UserModel();
        when(userReadService.findUserById(1L)).thenReturn(userModel);

        var response = userReadController.findUserById(1L);

        assertEquals(200, response.getStatusCode().value());
        assertEquals(userModel, response.getBody());
        verify(userReadService).findUserById(1L);
    }
}
