package com.nequer.android.business.manage.mvp.model;

public class ToCreateCalendarModel {


    /**
     * title : 中国好蛤丝黄历
     * description : 续命可以，不得暴力
     * picture : http://of1deuret.bkt.clouddn.com/17-11-6/86324838.jpg
     * is_public : 1
     * password : 123456
     * good_pick : 3
     * bad_pick : 3
     */

    private String title;
    private String description;
    private String picture;
    private int is_public;
    private String password;
    private int good_pick;
    private int bad_pick;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getIs_public() {
        return is_public;
    }

    public void setIs_public(int is_public) {
        this.is_public = is_public;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGood_pick() {
        return good_pick;
    }

    public void setGood_pick(int good_pick) {
        this.good_pick = good_pick;
    }

    public int getBad_pick() {
        return bad_pick;
    }

    public void setBad_pick(int bad_pick) {
        this.bad_pick = bad_pick;
    }
}
