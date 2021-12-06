package be.christophe.order.user.services;

import be.christophe.order.user.repositories.UserRepository;
import be.christophe.order.domain.users.User;
import be.christophe.order.domain.users.dto.CreateUser;
import be.christophe.order.domain.users.dto.UserDto;
import be.christophe.order.domain.users.mappers.ConvertCreateUserDto;
import be.christophe.order.domain.users.mappers.ConvertUserDto;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createNewUser(CreateUser createUser){
        User user = ConvertCreateUserDto.convertToUser(createUser);
        return ConvertUserDto.ConvertToUserDto(userRepository.insertUser(user));
    }
}
