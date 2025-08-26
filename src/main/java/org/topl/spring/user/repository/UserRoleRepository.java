package org.topl.spring.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.topl.spring.user.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
