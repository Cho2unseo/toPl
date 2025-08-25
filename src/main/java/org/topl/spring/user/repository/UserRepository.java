package org.topl.spring.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.topl.spring.user.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLoginId(String loginId);
}
