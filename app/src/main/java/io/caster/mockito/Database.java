package io.caster.mockito;

public interface Database {

    void deleteUser(String userId);

    void dropDatabase();
}
