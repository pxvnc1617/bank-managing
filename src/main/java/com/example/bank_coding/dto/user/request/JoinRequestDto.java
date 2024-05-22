package com.example.bank_coding.dto.user.request;

import com.example.bank_coding.domain.user.User;
import com.example.bank_coding.domain.user.UserRole;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Setter
public class JoinRequestDto {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String email;
    @NotEmpty
    private String fullName;

    // 여기는 f 브랜치입니다요ㅎㅎ

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
