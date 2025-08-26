package org.topl.spring.user.dto;

import lombok.Data;
import org.topl.spring.user.entity.User;

@Data
public class UserResponseDto {
    private String loginId;
    private String name;

    public UserResponseDto(User user) {
        this.loginId = user.getLoginId();
        this.name = user.getName();
    }
}
