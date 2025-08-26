package org.topl.spring.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class TodoRequestDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CreateTodoDto {
        private String content;
        private Boolean isDone = false;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private String memo;
    }
}
