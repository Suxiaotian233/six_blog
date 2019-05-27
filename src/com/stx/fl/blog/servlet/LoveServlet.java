package com.stx.fl.blog.servlet;

;

import com.stx.fl.blog.dao.CommentDao;
import com.stx.fl.blog.entity.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dianzan")
public class LoveServlet extends HttpServlet {

    CommentDao commentDao = new CommentDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        commentDao.loveInsert(id);
        req.getRequestDispatcher("/index").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
