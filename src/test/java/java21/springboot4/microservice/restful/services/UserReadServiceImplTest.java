package java21.springboot4.microservice.restful.services;

import java21.springboot4.microservice.restful.commons.exceptions.NotFoundException;
import java21.springboot4.microservice.restful.models.UserModel;
import java21.springboot4.microservice.restful.repositories.UserReadRepository;
import java21.springboot4.microservice.restful.services.impl.UserReadServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserReadServiceImplTest {

    @Mock
    private UserReadRepository userReadRepository;

    @InjectMocks
    private UserReadServiceImpl userReadService;

    @Test
    void whenFindAllUsersCalled_thenReturnsUsers() {
        List<UserModel> users = List.of(new UserModel());
        when(userReadRepository.findAll()).thenReturn(users);

        List<UserModel> result = userReadService.findAllUsers();

        assertEquals(users, result);
        verify(userReadRepository).findAll();
    }

    @Test
    void whenFindUserByIdCalledWithExistingId_thenReturnsUser() {
        UserModel userModel = new UserModel();
        when(userReadRepository.findById(1L)).thenReturn(Optional.of(userModel));

        UserModel result = userReadService.findUserById(1L);

        assertEquals(userModel, result);
        verify(userReadRepository).findById(1L);
    }

    @Test
    void whenFindUserByIdCalledWithUnknownId_thenThrowsNotFoundException() {
        when(userReadRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> userReadService.findUserById(1L));
        verify(userReadRepository).findById(1L);
    }
}
