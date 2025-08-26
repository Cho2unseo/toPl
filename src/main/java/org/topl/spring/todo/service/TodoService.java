package org.topl.spring.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.topl.spring.todo.dto.TodoRequestDto;
import org.topl.spring.todo.entity.Todo;
import org.topl.spring.todo.repository.TodoRepository;
import org.topl.spring.user.entity.User;
import org.topl.spring.user.repository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    public void createTodo(TodoRequestDto.CreateTodoDto createTodoDto, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        Todo todo = Todo.builder()
                .content(createTodoDto.getContent())
                .isDone(createTodoDto.getIsDone())
                .startDate(createTodoDto.getStartDate())
                .endDate(createTodoDto.getEndDate())
                .memo(createTodoDto.getMemo())
                .build();

        user.addTodo(todo);
        todoRepository.save(todo);
    }
}
