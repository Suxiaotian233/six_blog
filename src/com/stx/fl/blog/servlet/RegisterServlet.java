package com.stx.fl.blog.servlet;

;

import com.stx.fl.blog.dao.UserDao;
import com.stx.fl.blog.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置注册按钮
        req.setAttribute("register",1);
        req.getRequestDispatcher("/login_register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");
        String nickName = req.getParameter("nickname");
        String email = req.getParameter("email");


        String msg = null;
        //判断用户名密码是否为空
        if ((userName != "")&&(passWord != "")&&(nickName != "")) {
            User user1 = userDao.selectByUserName(userName);
            if (user1 == null){
                userDao.insert(userName,passWord,nickName,email);
                resp.sendRedirect("/index");
            }else {
                msg = "用户名已存在不可用";
                req.setAttribute("msg", msg);
                req.getRequestDispatcher("/error.jsp");
            }
        }else {
            msg = "用户名、密码或昵称不得为空";
            req.setAttribute("msg",msg);
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }




    }
}
