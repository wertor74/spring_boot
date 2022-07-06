package ru.wertor.spring_boot.service;

import ru.wertor.spring_boot.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> findAll();

    User saveUser(User user);

    void deleteById(Long id);
}
