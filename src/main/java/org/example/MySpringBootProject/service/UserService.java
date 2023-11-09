package org.example.MySpringBootProject.service;

import org.example.MySpringBootProject.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    void delete(int id);

    void edit(User user);

    User getUserById(int id);

    List<User> getUsers();
}
