package org.example.MySpringBootProject.dao;

import org.example.MySpringBootProject.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    void delete(int id);

    void edit(User user);

    List<User> getUsers();

    User getUserById(int id);
}
