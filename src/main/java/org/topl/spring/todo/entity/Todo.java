package org.topl.spring.todo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.topl.spring.user.entity.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "`todo`")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;

    @Column(nullable = false, length = 200)
    private String content;

    @Column(nullable = false)
    private Boolean isDone;

    @Column
    private LocalDateTime startDate;

    @Column
    private LocalDateTime endDate;

    @Column(length = 500)
    private String memo;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
