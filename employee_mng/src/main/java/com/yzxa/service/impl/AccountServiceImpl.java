package com.yzxa.service.impl;

import com.yzxa.dao.AccountDao;
import com.yzxa.domain.Account;
import com.yzxa.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAccountByAcount(Account account) {
        return accountDao.findAccountByAcount(account);
    }

    @Override
    public List<Account> findByParams(Account account) {
        return accountDao.findByParams( account);
    }
}
