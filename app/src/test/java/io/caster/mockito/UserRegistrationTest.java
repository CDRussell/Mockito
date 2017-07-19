package io.caster.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;

public class UserRegistrationTest {

    private UserRegistration testee;

    private Database mockDatabase;

    @Before
    public void setup() {
        mockDatabase = Mockito.mock(Database.class);
        testee = new UserRegistration(mockDatabase);
    }

    @Test
    public void shouldCallMockAMinimumNumberOfTimes() throws IOException {
        List<String> userIds = new ArrayList<>();
        userIds.add("a");
        userIds.add("b");
        userIds.add("c");

        testee.deleteUsers(userIds);

        Mockito.verify(mockDatabase, Mockito.atLeast(2)).deleteUser(anyString());
    }

    @Test
    public void shouldCallMockAMaximumNumberOfTimes() throws IOException {
        List<String> userIds = new ArrayList<>();
        userIds.add("a");
        userIds.add("b");
        userIds.add("c");

        testee.deleteUsers(userIds);

        Mockito.verify(mockDatabase, Mockito.atMost(5)).deleteUser(anyString());
    }

    @Test
    public void shouldCallMockANumberOfTimesAsARange() throws IOException {
        List<String> userIds = new ArrayList<>();
        userIds.add("a");
        userIds.add("b");
        userIds.add("c");

        testee.deleteUsers(userIds);

        Mockito.verify(mockDatabase, Mockito.atLeast(2)).deleteUser(anyString());
        Mockito.verify(mockDatabase, Mockito.atMost(5)).deleteUser(anyString());
    }
}





