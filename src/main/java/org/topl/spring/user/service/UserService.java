package org.topl.spring.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.topl.spring.user.dto.UserRequestDto;
import org.topl.spring.user.entity.User;
import org.topl.spring.user.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public String signUp(UserRequestDto.SignUpDto requestDto) {
        Optional<User> findUser = userRepository.findByLoginId(requestDto.getLoginId());
        if (findUser.isPresent()) return "중복된 ID 입니다.";

        User user = User.builder()
                .loginId(requestDto.getLoginId())
                .password(requestDto.getPassword())
                .name(requestDto.getName())
                .birthDate(requestDto.getBirthDate())
                .build();

        userRepository.save(user);
        return "가입되었습니다.";
    }
}
