package com.example.bank_coding.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRole {
    ADMIN("관리자"), USER("고객");

    private String value;
}
