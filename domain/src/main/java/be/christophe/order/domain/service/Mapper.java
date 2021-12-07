package be.christophe.order.domain.service;

import be.christophe.order.domain.items.Item;
import be.christophe.order.domain.items.Price;
import be.christophe.order.domain.items.dto.ItemDto;
import be.christophe.order.domain.users.Address;
import be.christophe.order.domain.users.City;
import be.christophe.order.domain.users.Street;
import be.christophe.order.domain.users.User;
import be.christophe.order.domain.users.dto.CreateUserDto;
import be.christophe.order.domain.users.dto.UserDto;

public class Mapper {
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
                createUser.getPhoneNumber());
    }

    private static String userAddressToString(User user) {
        Address address = user.getAddress();
        StringBuilder addressString = new StringBuilder();
        addressString.append(address.getStreet().getStreet());
        addressString.append(" " + address.getHouseNumber());
        addressString.append(", " + address.getStreet().getCity().getZipCode());
        addressString.append(" " + address.getStreet().getCity().getCityName());
        return addressString.toString();
    }

    public static Item mapper(ItemDto itemDto) {
        return new Item(itemDto.getName(),
                itemDto.getDescription(),
                new Price(itemDto.getPrice(), itemDto.getCurrency()),
                itemDto.getAmountStock());
    }

    public static ItemDto mapper(Item item) {
        return new ItemDto(item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice().getPrice(),
                item.getPrice().getCurrency(),
                item.getAmountStock());
    }
}
