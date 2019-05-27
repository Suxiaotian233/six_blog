package com.stx.fl.blog.dao;

import com.stx.fl.blog.entity.User;
import com.stx.fl.core.DbTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;


public class UserDao{



    public User selectByUserName(String userName) {
        User user = null;
        Connection conn =null;
        PreparedStatement stmt = null;
        ResultSet rs =null;

        try {
            conn = DbTools.getConnection();
            String sql = "select * from user where username = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,userName);
            rs = stmt.executeQuery();
            while (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassWord(rs.getString("password"));
                user.setNickName(rs.getString("nickname"));
                user.setUpicture(rs.getString("upicture"));
                user.setEmail(rs.getString("email"));
                user.setLove(rs.getInt("love"));
                user.setFans(rs.getInt("fans"));
                user.setWeiBo(rs.getInt("weibo"));
                user.setStatus(rs.getInt("status"));

                Timestamp time = rs.getTimestamp("addtime");
                Date addtime = new Date(time.getTime());
                user.setAddTime(addtime);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbTools.close(rs);
            DbTools.close(stmt);
            DbTools.close(conn);
        }


        return user;
    }

    public void insert(String userName, String passWord, String nickName, String email) {
        Connection conn =null;
        PreparedStatement stmt = null;

        try {
            conn = DbTools.getConnection();
            String sql = "insert into user(username,password,nickname,email,addtime) values (?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,userName);
            stmt.setString(2,passWord);
            stmt.setString(3,nickName);
            stmt.setString(4,email);

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


}
