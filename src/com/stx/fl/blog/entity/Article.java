package com.stx.fl.blog.entity;

import com.stx.fl.core.Entity;

import java.util.Date;

public class Article extends Entity {

    private User user;

    private String title;

    private Date addTime;

    private String summary;

    private String comment;

    private String content;

    private String picture;

    private Integer readTotal;

    private Integer dznumber;

    private Integer plnumber;

    public Article(){

    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getReadTotal() {
        return readTotal;
    }

    public void setReadTotal(Integer readTotal) {
        this.readTotal = readTotal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getDznumber() {
        return dznumber;
    }

    public void setDznumber(Integer dznumber) {
        this.dznumber = dznumber;
    }

    public Integer getPlnumber() {
        return plnumber;
    }

    public void setPlnumber(Integer plnumber) {
        this.plnumber = plnumber;
    }
}
