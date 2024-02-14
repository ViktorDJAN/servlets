package org.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

import static org.example.Resources.PAGE_LOGIN;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        // Ваша релизация фильтра входа пользователя на сайт

        if (true) { // Проверка, что пользователь авторизован (необходимо реализовать!!!)
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            httpServletRequest.getRequestDispatcher(PAGE_LOGIN).forward(request, response);
            return;
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
