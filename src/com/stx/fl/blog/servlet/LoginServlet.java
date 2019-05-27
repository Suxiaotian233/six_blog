package com.stx.fl.blog.servlet;

;

import com.stx.fl.blog.dao.UserDao;
import com.stx.fl.blog.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置登录按钮，用1来表示
        req.setAttribute("login",1);
        req.getRequestDispatcher("/login_register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");



        boolean ok = false;//登陆成功判断
        String msg = null;//错误信息提示

        User user = userDao.selectByUserName(userName);

        if (userName == null){
            msg = "登陆失败，用户名不能为空";
        }else {
            if (user == null){
                msg = "用户不存在";
                req.setAttribute("msg",msg);
                req.getRequestDispatcher("/error.jsp");
            }else {
                String dbPassword = user.getPassWord();
                if (passWord.equals(dbPassword)) {
                    ok = true;
                } else {
                    msg = "密码错误";
                    req.setAttribute("msg", msg);
                    req.getRequestDispatcher("/error.jsp");
                }
            }
        }

        if (ok){
            HttpSession session = req.getSession();
            session.setAttribute("login_user",user);
            resp.sendRedirect("/index");
        }else {
            req.setAttribute("title","登陆失败");
            req.setAttribute("msg",msg);
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }



    }
}
