package java21.springboot4.microservice.restful.services;

import java21.springboot4.microservice.restful.commons.exceptions.NotFoundException;
import java21.springboot4.microservice.restful.repositories.UserDeleteRepository;
import java21.springboot4.microservice.restful.services.impl.UserDeleteServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;

/**
 * @author Christian Hume (DEV)
 * @version 1.0.0
 * @since 2026-08-09
 */
@ExtendWith(MockitoExtension.class)
class UserDeleteServiceImplTest {

    @Mock
    private UserDeleteRepository userDeleteRepository;

    @InjectMocks
    private UserDeleteServiceImpl userDeleteService;

    @Test
    void whenDeleteUserCalledWithExistingId_thenDeletesUser() {
        when(userDeleteRepository.existsById(1L)).thenReturn(true);

        assertDoesNotThrow(() -> userDeleteService.deleteUser(1L));

        verify(userDeleteRepository).deleteById(1L);
    }

    @Test
    void whenDeleteUserCalledWithUnknownId_thenThrowsNotFoundException() {
        when(userDeleteRepository.existsById(1L)).thenReturn(false);

        assertThrows(NotFoundException.class, () -> userDeleteService.deleteUser(1L));

        verify(userDeleteRepository).existsById(1L);
        verify(userDeleteRepository, never()).deleteById(1L);
    }
}
