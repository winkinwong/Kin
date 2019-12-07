package com.kin.maven.springboot.filter;

import com.kin.maven.springboot.exception.UserException;
import com.kin.maven.springboot.global.ThreadLocalHelper;
import com.kin.maven.springboot.model.User;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object sessionUser = session.getAttribute("login_user");
        /*
        * 从session中获取user数据
        * */
       if(sessionUser!=null && sessionUser instanceof User){
           System.out.println("This is SessionFilter");
           ThreadLocalHelper.setSessionUser((User) sessionUser);
       }
        filterChain.doFilter(request,response);
       /*
       * 移除当前线程用户，避免数据泄露
       * */
       ThreadLocalHelper.removeSessionUser();
    }
}
