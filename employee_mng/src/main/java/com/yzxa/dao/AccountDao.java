package com.yzxa.dao;

import com.yzxa.domain.Account;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountDao {
    /*@Select("select * from account_info where username=#{username} and password=#{password}")*/
    List<Account> findAccountByAcount(Account account);

    List<Account> findByParams(Account account);
}
