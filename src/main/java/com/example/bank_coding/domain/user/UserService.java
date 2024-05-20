package com.example.bank_coding.domain.user;

import com.example.bank_coding.exceptionHandler.ex.CustomApiException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.slf4j.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Transactional
    public JoinResponseDto join(JoinRequestDto joinRequestDto) {
        // 1. 동일 유저 이름이 있는지
        Optional<User> username = userRepository.findByUsername(joinRequestDto.getUsername());
        if (username.isPresent()) {
            throw new CustomApiException("동일한 username 존재");
        }
        // 2. 패스워드 인코딩
        User userPersistence = userRepository.save(joinRequestDto.toEntity(bCryptPasswordEncoder));

        // 3. dto 응답
        return new JoinResponseDto(userPersistence);
    }

    @Getter
    @Setter
    public static class JoinRequestDto {
        private String username;
        private String password;
        private String email;
        private String fullName;

        public User toEntity(BCryptPasswordEncoder bCryptPasswordEncoder) {
            return User.builder()
                    .username(username)
                    .password(bCryptPasswordEncoder.encode(password))
                    .email(email)
                    .fullName(fullName)
                    .role(UserRole.USER)
                    .build();
        }
    }

    @Getter
    @Setter
    public static class JoinResponseDto {
        private Long id;
        private String username;
        private String fullName;

        public JoinResponseDto(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.fullName = user.getFullName();
        }
    }
}
