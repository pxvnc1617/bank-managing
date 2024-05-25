package com.example.bank_coding.dto.user.request;

import com.example.bank_coding.domain.user.User;
import com.example.bank_coding.domain.user.UserRole;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Setter
public class JoinRequestDto {
    // 영문, 숫자 가능 길이 (2 - 20)
    @Pattern(regexp = "^[a-zA-Z0-9]{2,20}$", message = "영문 혹은 숫자로 2 - 20 자 이내로 작성해 주세요.")
    @NotEmpty
    private String username;

    // 길이 (4 - 20)
    @NotEmpty
    @Size(min = 4, max = 30)
    private String password;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "이메일 형식으로 작성해 주세요.")
    @NotEmpty
    private String email;

    @Pattern(regexp = "^[a-zA-Z가-힣]{1,20}", message = "한글/영문 1--20 자 이내로 작성해 주세요.")
    @NotEmpty
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
