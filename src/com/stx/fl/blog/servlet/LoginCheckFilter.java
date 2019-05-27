package com.stx.fl.blog.servlet;

import com.stx.fl.blog.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录权限校验器
 */
@WebFilter({
        "/user*",
        "/article_insert",
        "/article_modify",
        "/article_delete",
        "/comment_insert",
        "/comment_delete"
})
public class LoginCheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("login_user");
        //null强转不会报错，强转不会多小号，占用内存和cpu
        if (user == null){
            //没有登陆,跳转登录界面
            HttpServletResponse resp = (HttpServletResponse) response;
            resp.sendRedirect("/login");


        }else {
            //已经登录，效验通过，可以放行
            chain.doFilter(request,response);
        }


    }

    @Override
    public void destroy() {

    }
}
