package be.christophe.order.domain.users;

import java.util.UUID;

public class User {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final Address address;
    private final String phoneNumber;
    private final String userName;
    private final String password;

    public User(String firstName, String lastName, String emailAddress, Address address, String phoneNumber, String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
