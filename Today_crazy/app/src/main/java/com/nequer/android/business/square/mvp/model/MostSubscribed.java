package com.nequer.android.business.square.mvp.model;

public class MostSubscribed {

    /**
     * id : 3
     * title : 东秦老黄历
     * description : 这是只属于东秦人的老黄历
     * creatorId : 1
     * subscribed : 113
     * picture : http://cdn.marklux.cn/edd469c0-7223-4030-a340-f54ad3f7cd4b
     * createdAt : 1510496412850
     * updatedAt : 1511872013245
     * isPublic : 0
     * password : null
     * goodPick : 3
     * badPick : 3
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
    private Object password;
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

    public void setPassword(Object password) {
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
