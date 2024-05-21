package com.example.bank_coding.dto.user.response;

import com.example.bank_coding.domain.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class JoinResponseDto {
    private Long id;
    private String username;
    private String fullName;

    public JoinResponseDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.fullName = user.getFullName();
    }
}