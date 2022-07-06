package ru.wertor.spring_boot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.wertor.spring_boot.model.User;
import ru.wertor.spring_boot.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public User findById(Long id) {
        return userRepository.getOne(id);
    }

    @Transactional
    @Override
    public List<User> findAll () {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public void deleteById (Long id) {
        userRepository.deleteById(id);
    }
}
