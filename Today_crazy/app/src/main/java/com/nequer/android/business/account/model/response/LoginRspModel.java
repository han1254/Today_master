package com.nequer.android.business.account.model.response;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.nequer.android.App;

public class LoginRspModel {

    /**
     * code : 0
     * data : {"token":"20ae03cbc6d349cb902f93cf60d3ba89","user":{"name":"han1254","signature":"","avatar":"http://cdn.marklux.cn/4f65ff34-462d-401c-87b7-e350ecc9fe53","sex":-1,"createdAt":1556170713803,"updatedAt":1556170713803}}
     */

    private int code;
    private UserBean user;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public UserBean getUserBean(){return user;}

        /**
         * token : 20ae03cbc6d349cb902f93cf60d3ba89
         * user : {"name":"han1254","signature":"","avatar":"http://cdn.marklux.cn/4f65ff34-462d-401c-87b7-e350ecc9fe53","sex":-1,"createdAt":1556170713803,"updatedAt":1556170713803}
         */






        public static class UserBean {
            /**
             * name : han1254
             * signature :
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

            public void setToken(String token){
                this.token = token;
            }

            public String getToken(){
                return token;
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


            public static void saveUserInfo() {
                UserBean user = new UserBean();

                Log.d("look","Token is "+user.getToken());
                SharedPreferences sp = App.getInstance().getSharedPreferences("user_bean", Context.MODE_PRIVATE);
                sp.edit()
                        .putString(KEY_TOKEN,user.getToken())
                        .putString(KEY_NAME,user.getName())
                        .putString(KEY_AVATAR,user.getAvatar())
                        .putString(KEY_SIGNATURE,user.getSignature())
                        .apply();
            }
        }

}
