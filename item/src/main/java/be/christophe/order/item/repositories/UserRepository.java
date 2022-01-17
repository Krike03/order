package be.christophe.order.item.repositories;

import be.christophe.order.item.domain.users.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public User insertUser(User user) {
        entityManager.persist(user);
        return user;
    }

    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class)
                .getResultList();
    }

    public User findLoginUser(String userName, String password) {
        return entityManager.createQuery("select u from User u where u.userName = :username and u.password = : password", User.class)
                .setParameter("username", userName)
                .setParameter("password", password)
                .getSingleResult();
    }
}
