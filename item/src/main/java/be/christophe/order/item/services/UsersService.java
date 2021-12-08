package be.christophe.order.item.services;

import be.christophe.order.domain.exceptions.UserNotFound;
import be.christophe.order.domain.service.Mapper;
import be.christophe.order.domain.users.User;
import be.christophe.order.domain.users.dto.CreateUserDto;
import be.christophe.order.domain.users.dto.UserDto;
import be.christophe.order.item.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UsersService {

    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createNewUser(CreateUserDto createUser) {
        User user = Mapper.mapper(createUser);
        return Mapper.mapper(userRepository.insertUser(user));
    }

    public String login(String authorization) {
        String decodedString = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String userName = decodedString.substring(0, decodedString.indexOf(":"));
        String password = decodedString.substring(decodedString.indexOf(":") + 1);


        User user = userRepository.findLoginUser(userName, password);
        if (user == null) {
            throw new UserNotFound("User not found: check you're password and username");
        }
        return user.getId();
    }
}
