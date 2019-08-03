package com.nequer.android.business.detail.mvp.model;

import java.io.Serializable;

public class DetailCommentModel implements Serializable {

    /**
     * id : 2
     * calendarId : 1
     * userId : 1
     * userName : marky
     * userAvatar : http://of1deuret.bkt.clouddn.com/17-11-6/86324838.jpg
     * comment : {
     "comment":"我去，我怎么变最gay了"
     }
     * createdAt : 1509945551583
     */



    private int id;
    private int calendarId;
    private int userId;
    private String userName;
    private String userAvatar;
    private String comment;
    private long createdAt;


    public DetailCommentModel(){}
    public DetailCommentModel(String comment){
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(int calendarId) {
        this.calendarId = calendarId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvator() {
        return userAvatar;
    }

    public void setUserAvator(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
