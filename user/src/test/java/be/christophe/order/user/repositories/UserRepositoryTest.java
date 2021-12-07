package be.christophe.order.user.repositories;

import be.christophe.order.domain.users.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserRepositoryTest {
    User user;
    UserRepository userRepository;

    @BeforeEach
    void setUp(){
        Address address = new Address("156", new Street("streetName", new City("2122", "cityName")));
        user = new User("first", "last", "email@email.com", address, "046546846");
        userRepository = new UserRepository();
    }

    @Test
    void testInsertAUser() {
        assertThat(userRepository.insertUser(user)).isInstanceOf(User.class);

        assertThat(userRepository.getAllUsers()).contains(user);
    }
}