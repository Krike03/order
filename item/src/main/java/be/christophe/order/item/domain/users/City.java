package be.christophe.order.item.domain.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "zipcode")
    private String zipCode;

    @Column(name = "city_name")
    private String cityName;


    public City(String zipCode, String cityName) {
        this.zipCode = zipCode;
        this.cityName = cityName;
    }

    private City() { }

    public String getZipCode() {
        return zipCode;
    }

    public String getCityName() {
        return cityName;
    }
}
