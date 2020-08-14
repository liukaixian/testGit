package com.yzxa.service;

import com.yzxa.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;
public interface AccountService {
    List<Account> findAccountByAcount(Account account);

    List<Account> findByParams(Account account);
}
