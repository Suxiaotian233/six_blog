package com.stx.fl.blog.servlet;

;

import com.stx.fl.blog.dao.ArticleDao;
import com.stx.fl.blog.entity.Article;
import com.stx.fl.blog.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/geren")
public class UserServlet extends HttpServlet {

    ArticleDao articleDao = new ArticleDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<Article> articleList = articleDao.selectAll();
        req.setAttribute("article",articleList);
        req.getRequestDispatcher("/geren.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
