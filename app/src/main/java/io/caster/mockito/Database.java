package io.caster.mockito;

import java.util.List;

public interface Database {

    void addUser(String emailAddress);

    boolean hasUser(String emailAddress);

    void deleteUser(String emailAddress) throws UserNotFoundException;

    List<String> getUsers();

    int numberOfUsers();

    boolean isReadWriteSupported();

    String getDatabaseName();
}
