package org.topl.spring.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class UserRequestDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class SignUpDto {
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z0-9_]{5,20}",
        message = "영문, 숫자, _만을 사용하세요")
        private String loginId;
        @NotBlank
        @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@$%^&*])[a-zA-Z0-9!@$%^&*]{8,20}",
                message = "영문, 숫자, 특수문자를 포함한 10~20 자리로 입력해주세요.")
        private String password;
        @NotBlank
        @Pattern(regexp = "^[ㄱ-힣]{1,10}",
                message = "올바른 이름을 입력하세요.")
        private String name;
        @Past(message = "유효한 날짜를 입력하세요.")
        private LocalDate birthDate;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class LoginDto {
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z0-9_]{5,20}",
                message = "영문, 숫자, _만을 5~20자리로 사용하세요")
        @Size(min = 5, max = 20,
        message = "5~20자 사이로 입력하세요.")
        private String loginId;
        @NotBlank
        @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@$%^&*])[a-zA-Z0-9!@$%^&*]{8,20}",
                message = "영문, 숫자, 특수문자를 포함한 10~20 자리로 입력해주세요.")
        @Size(min = 5, max = 20,
        message = "8~20자 사이로 입력하세요.")
        private String password;
    }


}
