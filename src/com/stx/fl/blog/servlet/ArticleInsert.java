package com.stx.fl.blog.servlet;



import com.stx.fl.blog.dao.ArticleDao;
import com.stx.fl.blog.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/article_insert")
public class ArticleInsert extends HttpServlet {

    ArticleDao articleDao = new ArticleDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/article_form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String summary = req.getParameter("summary");
        String content = req.getParameter("content");
        User user = (User) req.getSession().getAttribute("login_user");

        String msg = null;
        if ((title != "")&&(summary != "")&&(content != "")) {
            articleDao.insert(title, summary, content, user);
            //修改完成重新访问首页
            resp.sendRedirect("/index");
        }else {
            msg = "发表失败";
            req.setAttribute("msg", msg);
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }

    }
}
