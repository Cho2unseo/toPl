package org.topl.spring.todo.dto;

import lombok.*;
import org.topl.spring.todo.entity.Todo;

import java.time.LocalDateTime;

public class TodoResponseDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    public static class TodoDetailDto {
        private Long todoId;
        private String content;
        private Boolean isDone;
        private LocalDateTime startDate;
        private LocalDateTime endDate;

        public static TodoDetailDto from(Todo todo) {
            return TodoDetailDto.builder()
                    .todoId(todo.getTodoId())
                    .content(todo.getContent())
                    .isDone(todo.getIsDone())
                    .startDate(todo.getStartDate())
                    .endDate(todo.getEndDate())
                    .build();
        }
    }
}
