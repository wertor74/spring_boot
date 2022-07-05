package ru.wertor.spring_boot.service;

import org.springframework.stereotype.Service;
import ru.wertor.spring_boot.model.User;
import ru.wertor.spring_boot.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.getOne(id);
    }

    public List<User> findAll () {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteById (Long id) {
        userRepository.deleteById(id);
    }
}
