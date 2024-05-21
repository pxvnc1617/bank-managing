package com.example.bank_coding.dto.user.request;

import com.example.bank_coding.domain.user.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Setter
public class JoinRequestDto {
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
                .build();
    }
}
