package io.caster.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;

public class UserRegistrationTest {

    private UserRegistration testee;

    private Database mockDatabase;

    @Before
    public void setup() {
        mockDatabase = Mockito.mock(Database.class);

        testee = new UserRegistration(mockDatabase);
    }

    @Test(expected = UserAlreadyRegisteredException.class)
    public void shouldThrowExceptionWhenUserAlreadyRegistered() throws UserAlreadyRegisteredException {
        /*
         * Both of these are functionally equivalent in this example
             Mockito.when(mockDatabase.hasUser(anyString())).thenReturn(true);
             Mockito.doReturn(true).when(mockDatabase).hasUser(anyString());
         */
        Mockito.doReturn(true).when(mockDatabase).hasUser(anyString());
        testee.registerNewUser("foo@example.com");
    }

    @Test
    public void shouldAddNewUserToDatabase() throws UserAlreadyRegisteredException, IOException {
        String emailAddress = "foo@example.com";
        Mockito.when(mockDatabase.hasUser(emailAddress)).thenReturn(false);
        testee.registerNewUser(emailAddress);
        Mockito.verify(mockDatabase).addUser(emailAddress);
    }

    @Test (expected = UserNotFoundException.class)
    public void shouldThrowExceptionDeletingUserNotInDatabase() throws UserNotFoundException {
        String email = "foo@example.com";

        Mockito.doThrow(UserNotFoundException.class).when(mockDatabase).deleteUser(email);

        testee.deleteUser(email);
    }
}