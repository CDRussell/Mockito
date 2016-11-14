package io.caster.mockito;

public class UserRegistration {

    private Database database;

    /* this does not use Dependency Injection;
     *     - this class is tied to SimpleDatabase implementation
     *     - no other implementation of a Database can be provided, even during unit testing
     */
    public UserRegistration() {
        this.database = new SimpleDatabase();
    }

    /* this uses Dependency Injection;
     *     - the database is given to this method
     *     - this method doesn't have to worry about fetching the database reference
     *     - alternative database implementations can be provided
     */
    public UserRegistration(Database database) {
        this.database = database;
    }

    public void registerNewUser(String emailAddress) throws UserAlreadyRegisteredException {
        if (database.hasUser(emailAddress)) {
            throw new UserAlreadyRegisteredException();
        }

        database.addUser(emailAddress);
    }
}