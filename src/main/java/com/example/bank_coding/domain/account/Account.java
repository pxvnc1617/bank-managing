package com.example.bank_coding.domain.account;

import com.example.bank_coding.domain.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "account_table")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private Long accountNumber; // 계좌 번호
    @Column(nullable = false, unique = true, length = 4)
    private Long accountPassword; // 계좌 비밀 번호
    @Column(nullable = false)
    private Long balance; // 계좌 잔액 (기본값: 1000원)

    // 한 명의 사용자는 다수의 계좌를 가질 수 있다.
    // 외래키의 주인은 항상 다수 Entity 이다.
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public Account(Long id, Long accountNumber, Long accountPassword, Long balance, User user,
                   LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountPassword = accountPassword;
        this.balance = balance;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
