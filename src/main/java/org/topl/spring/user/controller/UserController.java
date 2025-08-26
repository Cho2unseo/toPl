package org.topl.spring.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.topl.spring.common.auth.CustomUser;
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

    @GetMapping("")
    public ApiResponse<?> myInfo() {
        Long userId = ((CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        return ApiResponse.ok(userService.userInfo(userId));
    }
}
