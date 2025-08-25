package org.topl.spring.user.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.topl.spring.common.status.Role;

@Entity
@Getter
@NoArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "id"))
    private User user;

    @Builder
    private UserRole(Long id, Role role, User user) {
        this.id = id;
        this.role = role;
        this.user = user;
    }
}
