package be.christophe.order.domain.users;

public class Street {
    private final String street;
    private final City city;

    public Street(String street, City city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public City getCity() {
        return city;
    }
}
