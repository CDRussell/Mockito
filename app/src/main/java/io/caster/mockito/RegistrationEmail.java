package io.caster.mockito;

public class RegistrationEmail {

    private String destinationEmailAddress;

    public RegistrationEmail(String destinationEmailAddress) {
        this.destinationEmailAddress = destinationEmailAddress;
    }

    public String getDestinationEmailAddress() {
        return destinationEmailAddress;
    }

    public void setDestinationEmailAddress(String destinationEmailAddress) {
        this.destinationEmailAddress = destinationEmailAddress;
    }
}
