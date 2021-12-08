package be.christophe.order.domain.users.dto;

public class CreateUserDto {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String streetName;
    private String houseNumber;
    private String zipCode;
    private String cityName;
    private String phoneNumber;
    private String userName;
    private String password;

    public CreateUserDto withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CreateUserDto withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CreateUserDto withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public CreateUserDto withStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public CreateUserDto withHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public CreateUserDto withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public CreateUserDto withCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public CreateUserDto withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public CreateUserDto withPassword(String password) {
        this.password = password;
        return this;
    }

    public CreateUserDto withUserName(String userName) {
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
