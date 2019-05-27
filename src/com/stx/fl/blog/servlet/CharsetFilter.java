package com.stx.fl.blog.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 字符集过滤器
 */
@WebFilter("/*")
public class CharsetFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/jsp; charset=UTF-8");
        response.setCharacterEncoding("utf-8");

        //放行操作
        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }
}