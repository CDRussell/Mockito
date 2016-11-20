package io.caster.mockito;

public interface Database {
    void addUser(String emailAddress);

    boolean hasUser(String emailAddress);

    void deleteUser(String emailAddress) throws UserNotFoundException;
}
