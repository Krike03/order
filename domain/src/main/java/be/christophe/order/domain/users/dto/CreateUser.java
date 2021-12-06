package be.christophe.order.domain.users.dto;

public class CreateUser {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String streetName;
    private String houseNumber;
    private String zipCode;
    private String cityName;
    private String phoneNumber;

    public CreateUser withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CreateUser withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CreateUser withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public CreateUser withStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public CreateUser withHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public CreateUser withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public CreateUser withCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public CreateUser withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
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

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCityName() {
        return cityName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
