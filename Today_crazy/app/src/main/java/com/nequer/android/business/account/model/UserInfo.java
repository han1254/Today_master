package com.nequer.android.business.account.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.nequer.android.App;
import com.nequer.android.utils.CacheUtil;

import java.util.List;

import static com.nequer.android.common.CacheKey.KEY_CALENDARLISTJSON;

public class UserInfo {


    /**
     * name : han1254
     * signature : 像少年啊飞
     * avatar : http://cdn.marklux.cn/4f65ff34-462d-401c-87b7-e350ecc9fe53
     * sex : -1
     * createdAt : 1556170713803
     * updatedAt : 1556170713803
     */


    private static String KEY_TOKEN = "TOKEN";
    private static String KEY_NAME = "NAME";
    private static int KEY_SEX = -1;
    private static String KEY_SIGNATURE = "SIGNATURE";
    private static String KEY_AVATAR = "AVATAR";

    private String token;
    private String name;
    private String signature;
    private String avatar;
    private int sex;
    private long createdAt;
    private long updatedAt;
    private List calendarList;

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
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

    public List getCalendarList(){ return calendarList; }

    public void setCalendarList(List calendarList){ this.calendarList = calendarList; }


    /**
     * 保存用户的基本信息
     */
    public void saveUserInfo(){

       SharedPreferences sharedPreferences = CacheUtil.getSP();
       sharedPreferences.edit()
               .putString(KEY_NAME,this.name)
               .putString(KEY_AVATAR,this.avatar)
               .putString(KEY_SIGNATURE,this.signature)
               .putString(KEY_TOKEN,this.token)

               .apply();
    }


    /**
     * 保存用户的订阅信息
     */
    public void saveUserSubcribedCalendar(){
        Gson calendarGson = new Gson();
        String calendarJson = calendarGson.toJson(calendarList);
        SharedPreferences sp = CacheUtil.getSP();
        sp.edit()
                .putString(KEY_CALENDARLISTJSON,calendarJson)
                .apply();

    }

    /**
     * 清除用户保存在本地的信息
     */

    public void clearUserInfo(){
        SharedPreferences sp = CacheUtil.getSP();
        sp.edit().clear().apply();

    }


}
