package com.example.bank_coding.domain.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Table(name = "user_table")
@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 20)
    private String username;
    @Column(unique = true, nullable = false, length = 60)
    private String password;
    @Column(nullable = false, length = 20)
    private String email;
    @Column(nullable = false, length = 20)
    private String fullName;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;       // ADMIN, CUSTOMER 들어감

    @CreatedDate // Insert 시 자동으로 날짜가 들어감
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate // Insert 및 Update 시에 자동으로 날짜가 들어감
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    // builder 생성하기
    @Builder
    public User(Long id, String username, String password, String email, String fullName, UserRole role,
                LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
