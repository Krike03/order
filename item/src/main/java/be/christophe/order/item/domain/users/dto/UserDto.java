package be.christophe.order.item.domain.users.dto;


public class UserDto {
    private String id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String address;
    private String phoneNumber;

    public UserDto withId(String id){
        this.id = id;
        return this;
    }

    public UserDto withFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public UserDto withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public UserDto withEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
        return this;
    }

    public UserDto withAddress(String address){
        this.address = address;
        return this;
    }

    public UserDto withPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserDto build(){
        return this;
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

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


}
