package com.stx.fl.blog.dao;

import com.stx.fl.blog.entity.Article;
import com.stx.fl.blog.entity.Comment;
import com.stx.fl.blog.entity.User;
import com.stx.fl.core.DbTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentDao {


    public List<Comment> selectAll(String id) {
        List<Comment> commentList = new ArrayList<>();

        Connection conn =null;
        PreparedStatement stmt = null;
        ResultSet rs =null;

        try {
            conn = DbTools.getConnection();
            String sql = "SELECT c.*, u.nickname, u.upicture FROM comments c,article a,user u WHERE  c.article_id = a.id and c.user_id = u.id AND a.id = ? and c.status = 1 ORDER BY ADDTIME DESC";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,id);
            rs = stmt.executeQuery();
            Comment comment = null;
            while (rs.next()){
                comment =new Comment();
                comment.setComment(rs.getString("comment"));
                comment.setDzNumber(rs.getInt("dznumber"));
                comment.setId(rs.getInt("id"));

                Timestamp time = rs.getTimestamp("addtime");
                Date addTime = new Date(time.getTime());
                comment.setAddTime(addTime);

                Article article = new Article();
                article.setId(rs.getInt("article_id"));
                comment.setArticle(article);

                User user = new User();
                user.setId(rs.getInt("user_id"));
                user.setNickName(rs.getString("nickname"));
                user.setUpicture(rs.getString("upicture"));
                comment.setUser(user);

                commentList.add(comment);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbTools.close(rs);
            DbTools.close(stmt);
            DbTools.close(conn);
        }

        return commentList;
    }

    public void insert(User user, String article_id, String comment) {
        Connection conn =null;
        PreparedStatement stmt = null;

        try {
            conn = DbTools.getConnection();
            String sql = "insert into comments(user_id,article_id,addtime,comment) values (?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,user.getId());
            stmt.setString(2,article_id);
            Timestamp time = new Timestamp(System.currentTimeMillis());
            stmt.setTimestamp(3,time);
            stmt.setString(4,comment);

            stmt.executeUpdate();

            stmt.close();

            sql = "update article set plnumber=plnumber+1 where id = ?";
            stmt =conn.prepareStatement(sql);
            stmt.setString(1,article_id);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbTools.close(stmt);
            DbTools.close(conn);
        }

    }

    public void delect(String id) {
        Connection conn =null;
        PreparedStatement stmt = null;

        try {
            conn = DbTools.getConnection();
            String sql = "update comments set status = -1 where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,id);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbTools.close(stmt);
            DbTools.close(conn);
        }
    }

    public void loveInsert(String id) {
        Connection conn =null;
        PreparedStatement stmt = null;
        ResultSet rs =null;

        try {
            conn = DbTools.getConnection();


            String sql = "update article set dznumber=dznumber+1 where id = ?";
            stmt =conn.prepareStatement(sql);
            stmt.setString(1,id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbTools.close(rs);
            DbTools.close(stmt);
            DbTools.close(conn);
        }
    }
}
