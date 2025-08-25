package org.topl.spring.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.topl.spring.common.response.ApiResponse;
import org.topl.spring.user.dto.UserRequestDto;
import org.topl.spring.user.service.UserService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ApiResponse<?> signup(@RequestBody @Valid UserRequestDto.SignUpDto request) {
        return ApiResponse.ok(userService.signUp(request));
    }

    @PostMapping("/login")
    public ApiResponse<?> login(@RequestBody @Valid UserRequestDto.LoginDto request) {
        return ApiResponse.ok(userService.login(request));
    }
}
