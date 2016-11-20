package io.caster.mockito;


import java.util.ArrayList;
import java.util.List;

public class SimpleDatabase implements Database {

    private List<String> users = new ArrayList<>();

    @Override
    public void addUser(String emailAddress) {
        users.add(emailAddress);
    }

    @Override
    public boolean hasUser(String emailAddress) {
        return users.contains(emailAddress);
    }

    @Override
    public void deleteUser(String emailAddress) throws UserNotFoundException {
        if (!users.contains(emailAddress)) {
            throw new UserNotFoundException();
        }
        users.remove(emailAddress);
    }
}
