package io.caster.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class UserRegistrationTest {

    private UserRegistration testee;

    private Database mockDatabase;

    @Before
    public void setup() {
        mockDatabase = Mockito.mock(Database.class);
        testee = new UserRegistration(mockDatabase);
    }

    @Test
    public void shouldNotDropDatabaseWhenDeletingUsers() throws IOException {
        List<String> userIds = new ArrayList<>();
        testee.deleteUsers(userIds);

        // both of these lines are functionally identical
        verify(mockDatabase, times(0)).dropDatabase();
        verify(mockDatabase, never()).dropDatabase();
    }
}