package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;
import java.util.List;

public interface AdminService {
    void add(User user);
    void delete(Integer id);
    void update(User user);
    List<User> getUsers();
    User getUserByID(Integer id);
}
