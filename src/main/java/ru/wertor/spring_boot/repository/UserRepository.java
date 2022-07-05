package ru.wertor.spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.wertor.spring_boot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
