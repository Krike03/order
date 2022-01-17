package be.christophe.order.item.repositories;

import be.christophe.order.item.domain.users.Address;
import be.christophe.order.item.domain.users.City;
import be.christophe.order.item.domain.users.Street;
import be.christophe.order.item.domain.users.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserRepositoryTest {
    User user;
    UserRepository userRepository;

    @BeforeEach
    void setUp(){
        Address address = new Address("156", new Street("streetName", new City("2122", "cityName")));
        user = new User("first", "last", "email@email.com", address, "046546846", "userName", "password");
        userRepository = new UserRepository();
    }

    @Test
    void testInsertAUser() {
        assertThat(userRepository.insertUser(user)).isInstanceOf(User.class);

        assertThat(userRepository.getAllUsers()).contains(user);
    }
}