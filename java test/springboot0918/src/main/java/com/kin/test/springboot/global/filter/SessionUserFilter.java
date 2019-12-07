package com.kin.test.springboot.global.filter;

import com.kin.test.springboot.global.util.ThreadLocalHelper;
import com.kin.test.springboot.model.User;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionUserFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        Object sessionUser = httpSession.getAttribute("login_user");

        /**
         * 从 session 中取数据，需要注意判断类型是否匹配
         */
        if (sessionUser != null &&  sessionUser instanceof User) {
            ThreadLocalHelper.setSessionUser((User) sessionUser);
        }

        filterChain.doFilter(request, response);

        /**
         * 清除线程中的用户信息，避免数据泄漏
         */
        ThreadLocalHelper.removeSessionUser();
    }
}
