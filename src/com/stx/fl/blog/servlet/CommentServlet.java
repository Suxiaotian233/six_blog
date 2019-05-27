package com.stx.fl.blog.servlet;

;

import com.stx.fl.blog.dao.ArticleDao;
import com.stx.fl.blog.dao.CommentDao;
import com.stx.fl.blog.entity.Article;
import com.stx.fl.blog.entity.Comment;
import com.stx.fl.blog.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/comment_insert")
public class CommentServlet extends HttpServlet {

    CommentDao commentDao = new CommentDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("login_user");
        String article_id = req.getParameter("a");
        String comment = req.getParameter("pinglun");
        String msg = null;

        if (comment != null){
            commentDao.insert(user,article_id,comment);
            resp.sendRedirect("/index");
        }else {
            msg = "评论为空";
            req.setAttribute("msg",msg);
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }


    }
}
