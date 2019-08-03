package com.nequer.android.business.manage.mvp.model;

import java.io.Serializable;

public class MyCreateModel implements Serializable {

    /**
     * id : 157
     * title : 没啥好说的
     * description : nothing
     * creatorId : 0
     * subscribed : 2
     * picture : http://cdn.marklux.cn/0233f76c-4e13-41ba-9e6c-4b85a8fc87bd
     * createdAt : 111111111111110
     * updatedAt : 22222222220
     * isPublic : 0
     * password : null
     * goodPick : 0
     * badPick : 0
     * isSubscribed : false
     */

    private int id;
    private String title;
    private String description;
    private int creatorId;
    private int subscribed;
    private String picture;
    private long createdAt;
    private long updatedAt;
    private int isPublic;
    private String password;
    private int goodPick;
    private int badPick;
    private boolean isSubscribed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public int getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(int subscribed) {
        this.subscribed = subscribed;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(int isPublic) {
        this.isPublic = isPublic;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGoodPick() {
        return goodPick;
    }

    public void setGoodPick(int goodPick) {
        this.goodPick = goodPick;
    }

    public int getBadPick() {
        return badPick;
    }

    public void setBadPick(int badPick) {
        this.badPick = badPick;
    }

    public boolean isIsSubscribed() {
        return isSubscribed;
    }

    public void setIsSubscribed(boolean isSubscribed) {
        this.isSubscribed = isSubscribed;
    }
}
