package io.caster.mockito;


import java.util.ArrayList;
import java.util.List;

public class SimpleDatabase implements Database {

    private List<String> users = new ArrayList<>();

    @Override
    public void deleteUser(String emailAddress) throws UserNotFoundException {
        users.remove(emailAddress);
    }

    @Override
    public void dropDatabase() {

    }
}
