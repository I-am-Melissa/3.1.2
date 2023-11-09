package org.example.MySpringBootProject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.MySpringBootProject.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void edit(User user) {
        User user2 = getUserById(user.getId());
        user2.setName(user.getName());
        user2.setLastName(user.getLastName());
        entityManager.merge(user2);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("From User", User.class).getResultList();
    }
}