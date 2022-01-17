package be.christophe.order.item.services;

import be.christophe.order.item.domain.users.Address;
import be.christophe.order.item.domain.users.City;
import be.christophe.order.item.domain.users.Street;
import be.christophe.order.item.domain.users.User;
import be.christophe.order.item.domain.users.dto.CreateUserDto;
import be.christophe.order.item.domain.users.dto.UserDto;

public class UserMapper {
    public static UserDto mapper(User user){
        return new UserDto()
                .withId(user.getId())
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withEmailAddress(user.getEmailAddress())
                .withPhoneNumber(user.getPhoneNumber())
                .withAddress(userAddressToString(user))
                .build();
    }

    public static User mapper(CreateUserDto createUser){
        City city = new City(createUser.getZipCode(), createUser.getCityName());
        Street street = new Street(createUser.getStreetName(), city);
        Address address = new Address(createUser.getHouseNumber(), street);

        return new User(createUser.getFirstName(),
                createUser.getLastName(),
                createUser.getEmailAddress(),
                address,
                createUser.getPhoneNumber(),
                createUser.getUserName(),
                createUser.getPassword());
    }

    private static String userAddressToString(User user) {
        Address address = user.getAddress();
        String addressString;
        addressString = address.getStreet().getStreet();
        addressString += " " + address.getHouseNumber();
        addressString += ", " + address.getStreet().getCity().getZipCode();
        addressString += " " + address.getStreet().getCity().getCityName();
        return addressString;
    }
}
