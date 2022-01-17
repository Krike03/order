package be.christophe.order.item.domain.users;

import javax.persistence.*;

@Entity
@Table(name = "street")
public class Street {

    @Id
    @SequenceGenerator(name = "street_seq", sequenceName = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "street_seq")
    private int id;

    @Column(name = "street_name")
    private String street;

    @OneToOne
    @JoinColumn(name = "fk_city_zipcode")
    private  City city;

    public Street(String street, City city) {
        this.street = street;
        this.city = city;
    }

    private Street() {

    }

    public String getStreet() {
        return street;
    }

    public City getCity() {
        return city;
    }
}
