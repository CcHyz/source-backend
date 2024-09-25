package com.cc.tips.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(1)
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("join doFilter AuthFilter");
//        int i = 1;
//        if (i == 1) {
//            throw new RemoteException("异常");
//        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
