package io.caster.mockito;

public class UserRegistration {

    private Database database;
    private EmailSender emailSender;

    public UserRegistration(Database database, EmailSender emailSender) {
        this.database = database;
        this.emailSender = emailSender;
    }

    public void registerNewUser(String emailAddress) throws UserAlreadyRegisteredException, EmailFailedException {
        if (database.hasUser(emailAddress)) {
            throw new UserAlreadyRegisteredException();
        }

        if(!emailSender.sendRegistrationEmail(new RegistrationEmail(emailAddress))) {
            throw new EmailFailedException();
        }
        database.addUser(emailAddress);
    }

    public void deleteUser(String emailAddress) throws UserNotFoundException {
        database.deleteUser(emailAddress);
    }


}