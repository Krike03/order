package be.christophe.order.domain.users.mappers;

import be.christophe.order.domain.users.Address;
import be.christophe.order.domain.users.User;
import be.christophe.order.domain.users.dto.UserDto;

public class ConvertUserDto {
    public static UserDto ConvertToUserDto(User user){
        return new UserDto()
                .withId(user.getId())
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withEmailAddress(user.getEmailAddress())
                .withPhoneNumber(user.getPhoneNumber())
                .withAddress(createAddress(user))
                .build();
    }

    private static String createAddress(User user) {
        Address address = user.getAddress();
        StringBuilder addressString = new StringBuilder();
        addressString.append(address.getStreet().getStreet());
        addressString.append(" " + address.getHouseNumber());
        addressString.append(", " + address.getStreet().getCity().getZipCode());
        addressString.append(" " + address.getStreet().getCity().getCityName());
        return addressString.toString();
    }
}
