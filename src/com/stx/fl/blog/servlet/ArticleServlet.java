package com.stx.fl.blog.servlet;

;

import com.stx.fl.blog.dao.ArticleDao;
import com.stx.fl.blog.dao.CommentDao;
import com.stx.fl.blog.entity.Article;
import com.stx.fl.blog.entity.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/article")
public class ArticleServlet extends HttpServlet {

    ArticleDao articleDao = new ArticleDao();
    CommentDao commentDao = new CommentDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        Article article = articleDao.selectById(id);
        req.setAttribute("a",article);
        List<Comment> commentList = commentDao.selectAll(id);
        req.setAttribute("comments",commentList);
        req.getRequestDispatcher("/article.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
