package be.christophe.order.item.domain.users;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user12")
public class User {

    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private String id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "email_address", length = 100)
    private String emailAddress;

    @OneToOne
    @JoinColumn(name = "fk_address_id")
    private Address address;

    @Column(name = "phone_number", length = 11)
    private String phoneNumber;

    @Column(name = "user_name", length = 50)
    private String userName;

    @Column(name = "password", length = 255)
    private String password;

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

    private User() {

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
