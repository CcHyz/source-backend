package com.cc.tips.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Component
@Order(12)
@WebFilter()
public class AuthTwoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("join doFilter AuthTwoFilter");
//        int i = 1;
//        if (i == 1) {
//            throw new RemoteException("异常");
//        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
