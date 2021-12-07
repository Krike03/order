package be.christophe.order.user.services;

import be.christophe.order.user.repositories.UserRepository;
import be.christophe.order.domain.users.User;
import be.christophe.order.domain.users.dto.CreateUserDto;
import be.christophe.order.domain.users.dto.UserDto;
import be.christophe.order.domain.service.Mapper;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createNewUser(CreateUserDto createUser){
        User user = Mapper.mapper(createUser);
        return Mapper.mapper(userRepository.insertUser(user));
    }
}
