package com.stx.fl.blog.dao;


import com.stx.fl.blog.entity.Article;
import com.stx.fl.blog.entity.User;
import com.stx.fl.core.DbTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleDao {
    public void insert(String title, String summary, String content, User user) {
        Connection conn =null;
        PreparedStatement stmt = null;

        try {
            conn = DbTools.getConnection();
            String sql = "insert into article(user_id, title, summary, content, addtime) values(?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,user.getId());
            stmt.setString(2,title);
            stmt.setString(3,summary);
            stmt.setString(4,content);

            Timestamp time = new Timestamp(System.currentTimeMillis());
            stmt.setTimestamp(5,time);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbTools.close(stmt);
            DbTools.close(conn);
        }
    }


    public Article selectById(String id) {
        Article article = null;

        Connection conn =null;
        PreparedStatement stmt = null;
        ResultSet rs =null;

        try {
            conn = DbTools.getConnection();
            //1.查询文章对象
            String sql = "select a.*, u.nickname, u.upicture from article a, user u where a.user_id = u.id and  a.id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,id);
            rs = stmt.executeQuery();

            while (rs.next()){
                article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setSummary(rs.getString("summary"));
                article.setReadTotal(rs.getInt("readtotal"));
                article.setContent(rs.getString("content"));
                article.setDznumber(rs.getInt("dznumber"));
                article.setPlnumber(rs.getInt("plnumber"));


                Timestamp time = rs.getTimestamp("addtime");
                Date addTime = new Date(time.getTime());
                article.setAddTime(addTime);

                User user =new User();
                user.setId(rs.getInt("user_id"));
                user.setNickName(rs.getString("nickname"));
                user.setUpicture(rs.getString("upicture"));

                article.setUser(user);

            }
            //2.增加文章阅读计数
            //提前关闭第一步使用的stmt
            stmt.close();
··
            sql = "update article set readtotal=readtotal+1 where id = ?";
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

        return article;
    }

    /**
     * 查询所有文章，并存储到一个集合中
     * @return
     */
    public List<Article> selectAll() {
        List<Article> articleList = new ArrayList<>();

        Connection conn =null;
        PreparedStatement stmt = null;
        ResultSet rs =null;

        try {
            conn = DbTools.getConnection();
            String sql = "select * from article where status = 1 order by id desc";
            //order by排序    ：asc正序  desc倒序
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            Article a;
            while (rs.next()){
                a = new Article();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setSummary(rs.getString("summary"));
                a.setPicture(rs.getString("picture"));
                a.setReadTotal(rs.getInt("readtotal"));
                a.setPlnumber(rs.getInt("plnumber"));
                a.setDznumber(rs.getInt("dznumber"));

                Timestamp time = rs.getTimestamp("addtime");
                Date addTime = new Date(time.getTime());
                a.setAddTime(addTime);

                User user = new User();
                user.setId(rs.getInt("user_id"));
                a.setUser(user);

                //把当前记录对象添加到列表
                articleList.add(a);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbTools.close(rs);
            DbTools.close(stmt);
            DbTools.close(conn);
        }

        return articleList;
    }
    /**
     * 这里是伪删除
     * @param id
     */
    public void delete(String id) {

        Connection conn =null;
        PreparedStatement stmt = null;

        try {
            conn = DbTools.getConnection();
            String sql = "update article set status = -1 where id = ?";
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

    /**
     * 使用更新操作，修改文章
     * @param id
     * @param title
     * @param summary
     * @param content
     */
    public void update(String id, String title, String summary, String content) {

        Connection conn =null;
        PreparedStatement stmt = null;

        try {
            conn = DbTools.getConnection();
            String sql = "update article set title = ?, summary = ?, content = ? where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,title);
            stmt.setString(2,summary);
            stmt.setString(3,content);
            stmt.setString(4,id);

            stmt.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbTools.close(stmt);
            DbTools.close(conn);
        }
    }


}
