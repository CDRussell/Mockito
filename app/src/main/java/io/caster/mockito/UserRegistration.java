package io.caster.mockito;

public class UserRegistration {

    private Database database;
    private EmailSender emailSender;

    public UserRegistration(Database database, EmailSender emailSender) {
        this.database = database;
        this.emailSender = emailSender;
    }

    public void registerNewUser(String emailAddress) throws UserAlreadyRegisteredException {
        if (database.hasUser(emailAddress)) {
            throw new UserAlreadyRegisteredException();
        }

        database.addUser(emailAddress);
        emailSender.sendVerificationEmail(emailAddress);
    }
}