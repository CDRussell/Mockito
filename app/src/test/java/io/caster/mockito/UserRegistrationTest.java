package io.caster.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyString;

public class UserRegistrationTest {

    private UserRegistration testee;

    private Database mockDatabase;

    @Before
    public void setup() {
        mockDatabase = Mockito.mock(Database.class);

        testee = new UserRegistration(mockDatabase);
    }

    @Test (expected = UserAlreadyRegisteredException.class)
    public void shouldThrowExceptionWhenUserAlreadyRegistered() throws UserAlreadyRegisteredException {
        Mockito.when(mockDatabase.hasUser(anyString())).thenReturn(true);
        testee.registerNewUser("foo@example.com");
    }
}