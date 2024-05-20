package com.example.bank_coding.domain.account;

import com.example.bank_coding.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
