package be.christophe.order.domain.users.mappers;

import be.christophe.order.domain.users.*;
import be.christophe.order.domain.users.dto.CreateUserDto;

public class ConvertCreateUserDto {
    public static User convertToUser(CreateUserDto createUser){
        City city = new City(createUser.getZipCode(), createUser.getCityName());
        Street street = new Street(createUser.getStreetName(), city);
        Address address = new Address(createUser.getHouseNumber(), street);

        return new User(createUser.getFirstName(),
                createUser.getLastName(),
                createUser.getEmailAddress(),
                address,
                createUser.getPhoneNumber());
    }
}
