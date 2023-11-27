package tddexamples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RegistrationTest {

    // Exemplo Unit Test
    @Test
    public void deveCadastrarUsuariosValidos() {
        Registration registration = new Registration();
        User registeredUser = registration.registerNewUser("Pedro", 19, "123456", "pedro@teste.com");

        assertNotNull(registeredUser, "O resultado não deveria ser nulo");
        assertEquals("Pedro", registeredUser.getName(), "O nome do usuário deve ser Pedro");
        assertEquals(19, registeredUser.getAge(), "A idade do usuário deve ser 19");
        assertEquals("123456", registeredUser.getPassword(), "A senha do usuário deve ser 123456");
        assertEquals("pedro@teste.com", registeredUser.getEmail(), "O email do usuário deve ser pedro@teste.com");
    }
























    // Exemplo Mock
    @Test
    public void deveEnviarEmailCadastro() {
        // Mock do serviço de email
        EmailService emailService = mock(EmailService.class);

        RegistrationForMocking registration = new RegistrationForMocking(emailService);

        User registeredUser = registration.registerNewUser("Pedro", 19, "123456", "pedro@teste.com");

        assertNotNull(registeredUser, "O resultado não deveria ser nulo");
        assertEquals("Pedro", registeredUser.getName(), "O nome do usuário deve ser Pedro");
        assertEquals(19, registeredUser.getAge(), "A idade do usuário deve ser 19");
        assertEquals("123456", registeredUser.getPassword(), "A senha do usuário deve ser 123456");
        assertEquals("pedro@teste.com", registeredUser.getEmail(), "O email do usuário deve ser pedro@teste.com");

        // Verifica se o serviço de email foi chamado com o email correto
        verify(emailService).sendConfirmationEmail("pedro@teste.com");
    }
































    // Exemplo Stub
    @Test
    public void deveValidarEmailnaBase() {
        // Mock do serviço de email
        EmailService emailService = mock(EmailService.class);

        DBService dbStubService = mock(DBService.class);
        when(dbStubService.validateEmail(anyString())).thenThrow(new RuntimeException("E-mail já está em uso!"));

        RegistrationForMocking registration = new RegistrationForMocking(emailService, dbStubService);

        assertThrows(RuntimeException.class, () -> registration.registerNewUserWithValidation("Pedro", 19, "123456", "pedro@teste.com"));
    }
}
