package org.topl.spring.todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.topl.spring.common.auth.CustomUser;
import org.topl.spring.todo.dto.TodoRequestDto;
import org.topl.spring.todo.service.TodoService;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping("/create")
    public ResponseEntity<?> createTodo(
            @AuthenticationPrincipal CustomUser user,
            @RequestBody TodoRequestDto.CreateTodoDto dto) {
        try {
            todoService.createTodo(dto, user.getUserId());
            return ResponseEntity.status(HttpStatus.CREATED).body("할 일 등록 성공");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 내부 오류가 발생했습니다.");
        }
    }
}
