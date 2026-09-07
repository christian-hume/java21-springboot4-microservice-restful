package java21.springboot4.microservice.restful.services;

import java21.springboot4.microservice.restful.commons.exceptions.NotFoundException;
import java21.springboot4.microservice.restful.models.UserModel;
import java21.springboot4.microservice.restful.repositories.UserUpdateRepository;
import java21.springboot4.microservice.restful.services.impl.UserUpdateServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserUpdateServiceImplTest {

    @Mock
    private UserUpdateRepository userUpdateRepository;

    @InjectMocks
    private UserUpdateServiceImpl userUpdateService;

    @Test
    void whenUpdateUserCalledWithExistingId_thenUpdatesAllowedFields() {
        UserModel existingUser = new UserModel();
        UserModel userUpdate = new UserModel();
        userUpdate.setFirstName("Updated");
        userUpdate.setEmail("updated@example.com");
        userUpdate.setOccupation("Engineer");
        when(userUpdateRepository.findById(1L)).thenReturn(Optional.of(existingUser));

        userUpdateService.updateUser(1L, userUpdate);

        assertEquals("Updated", existingUser.getFirstName());
        assertEquals("updated@example.com", existingUser.getEmail());
        assertEquals("Engineer", existingUser.getOccupation());
        verify(userUpdateRepository).save(existingUser);
    }

    @Test
    void whenUpdateUserCalledWithUnknownId_thenThrowsNotFoundException() {
        when(userUpdateRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> userUpdateService.updateUser(1L, new UserModel()));
    }
}
