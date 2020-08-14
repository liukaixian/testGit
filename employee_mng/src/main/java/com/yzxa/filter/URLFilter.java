package com.yzxa.filter;

import com.yzxa.domain.Account;
import com.yzxa.domain.Employee;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class URLFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Object obj = request.getSession().getAttribute("account");
        String uri = request.getRequestURI();
        if (uri.contains("index") ||uri.contains("login")){
            filterChain.doFilter(request,response);
        }else {
            if (obj == null) {
                response.sendRedirect("/index.jsp");
            } else {
                filterChain.doFilter(request,response);
                Account account = (Account) obj;

            }
        }
    }
}
