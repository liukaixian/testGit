package com.yzxa.controller;

import com.yzxa.domain.Account;
import com.yzxa.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/login")
    public String login(Account account, Model model, HttpServletRequest request) {

        List<Account> accounts = accountService.findAccountByAcount(account);

        if (accounts.isEmpty()) {
            model.addAttribute("login_msg", "账户或密码错误");

        }
        if (accounts.size() > 1) {
            model.addAttribute("login_msg", "数据异常请联系管理员");

        }
        if (accounts.size() == 1) {
            accounts.get(0);
            request.getSession().setAttribute("account",accounts.get(0));
            return "list";
        }
        return "login";
    }
    @RequestMapping("/findByParams")
    public String findByParams(Account account,Model model){
        List<Account> accounts = accountService.findByParams(account);
        model.addAttribute("accounts",accounts);
        return "admin";
    }
}