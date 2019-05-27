package com.stx.fl.blog.servlet;

;

import com.stx.fl.blog.dao.ArticleDao;
import com.stx.fl.blog.entity.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/article_modify")
public class ArticleUpdate extends HttpServlet {

    ArticleDao articleDao = new ArticleDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Article article = articleDao.selectById(id);
        req.setAttribute("a",article);
        req.getRequestDispatcher("/article_insert").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String summary = req.getParameter("summary");
        String content = req.getParameter("content");

        articleDao.update(id,title,summary,content);
        //修改完成重新访问首页
        resp.sendRedirect("/index");

    }
}
