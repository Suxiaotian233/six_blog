package com.stx.fl.core;

import java.sql.*;

public class DbTools{

    private static String dbUser = "root";
    private static String dbPassWord = "123456";
    private static String url = "jdbc:mysql://127.0.0.1:3306/blog?useSSL=false";


    public static Connection getConnection(){
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url,dbUser,dbPassWord);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return conn;
    }


    /**
     * 释放结果集
     * @param rs
     */
    public static void close(ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭操作语句
     * @param stmt
     */
    public static void close(Statement stmt){
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭链接
     * @param conn
     */
    public static void close(Connection conn){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
