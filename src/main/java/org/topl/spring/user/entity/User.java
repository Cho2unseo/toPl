package org.topl.spring.user.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.topl.spring.common.status.Role;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "`user`")
@Getter
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30, unique = true, updatable = false)
    private String loginId;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<UserRole> roles;

    @Builder
    private User(Long id, String loginId, String password, String name, LocalDate birthDate) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.birthDate = birthDate;
        this.roles = null;
    }
}
