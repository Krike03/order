package be.christophe.order.item.api;

import be.christophe.order.domain.users.dto.CreateUserDto;
import be.christophe.order.domain.users.dto.UserDto;
import be.christophe.order.item.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUsers() {
        return new UserDto().withAddress("adres")
                .withEmailAddress("email")
                .withFirstName("first")
                .withLastName("last")
                .withPhoneNumber("0654686")
                .build();
    }

    @PostMapping(consumes = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody CreateUserDto createUser) {
        return usersService.createNewUser(createUser);
    }

    @GetMapping(path = "/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestHeader("Authorization") String authorization) {
        return usersService.login(authorization);
    }

}
