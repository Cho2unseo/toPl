package org.topl.spring.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.topl.spring.todo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
