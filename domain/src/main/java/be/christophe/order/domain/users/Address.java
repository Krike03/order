package be.christophe.order.domain.users;

import be.christophe.order.domain.users.dto.CreateUser;

public class Address {
    private final String houseNumber;
    private final Street street;

    public Address(String houseNumber, Street street) {
        this.houseNumber = houseNumber;
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public Street getStreet() {
        return street;
    }
}
