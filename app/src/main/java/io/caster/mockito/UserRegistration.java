package io.caster.mockito;

import java.util.List;

public class UserRegistration {

    private Database database;

    public UserRegistration(Database database) {
        this.database = database;
    }

    public void deleteUsers(List<String> userIds) {
        for (String id : userIds) {
            database.deleteUser(id);
        }
    }

}