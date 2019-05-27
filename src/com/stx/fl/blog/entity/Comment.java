package com.stx.fl.blog.entity;

import com.stx.fl.core.Entity;

import java.util.Date;

public class Comment extends Entity {
    private Article article;

    private User user;

    private String comment;

    private Integer dzNumber;

    private Date addTime;

    public Comment(){

    }

    public Date getAddTime() {
        return addTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getDzNumber() {
        return dzNumber;
    }

    public void setDzNumber(Integer dzNumber) {
        this.dzNumber = dzNumber;
    }
}
