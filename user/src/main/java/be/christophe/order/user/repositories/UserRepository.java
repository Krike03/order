package be.christophe.order.user.repositories;

import be.christophe.order.domain.users.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private final Map<String, User> users;

    public UserRepository() {
        users = new ConcurrentHashMap<>();
    }

    public User insertUser(User user) {
        users.put(user.getId(), user);
        return user;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

}
