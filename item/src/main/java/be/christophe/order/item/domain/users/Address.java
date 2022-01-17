package be.christophe.order.item.domain.users;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @SequenceGenerator(name = "address_seq", sequenceName = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    private int id;

    @Column(name = "house_number")
    private String houseNumber;

    @OneToOne
    @JoinColumn(name = "fk_street_id")
    private Street street;

    public Address(String houseNumber, Street street) {
        this.houseNumber = houseNumber;
        this.street = street;
    }

    private Address() { }

    public String getHouseNumber() {
        return houseNumber;
    }

    public Street getStreet() {
        return street;
    }
}
