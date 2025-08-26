package org.topl.spring.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.topl.spring.common.auth.JwtTokenProvider;
import org.topl.spring.common.auth.TokenInfo;
import org.topl.spring.common.exception.InvalidInputException;
import org.topl.spring.common.status.Role;
import org.topl.spring.user.dto.UserRequestDto;
import org.topl.spring.user.dto.UserResponseDto;
import org.topl.spring.user.entity.User;
import org.topl.spring.user.entity.UserRole;
import org.topl.spring.user.repository.UserRepository;
import org.topl.spring.user.repository.UserRoleRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    public String signUp(UserRequestDto.SignUpDto requestDto) {
        if (userRepository.findByLoginId(requestDto.getLoginId()).isPresent()) {
            throw new InvalidInputException("loginId", "중복된 ID 입니다.");
        }

        User user = User.builder()
                .loginId(requestDto.getLoginId())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .name(requestDto.getName())
                .birthDate(requestDto.getBirthDate())
                .build();

        userRepository.save(user);

        UserRole userRole = UserRole.builder()
                .role(Role.USER)
                .user(user)
                .build();
        userRoleRepository.save(userRole);

        return "가입되었습니다.";
    }

    public TokenInfo login(UserRequestDto.LoginDto request) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(request.getLoginId(), request.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        return jwtTokenProvider.createToken(authentication);
    }

    public UserResponseDto userInfo(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new InvalidInputException("token", "회원 정보가 존재하지 않습니다."));
        return new UserResponseDto(user);
    }
}
