package com.nequer.android.business.detail.mvp.model;

import com.nequer.android.base.mvp.model.BaseModel;

import java.io.Serializable;
import java.util.List;

public class DetailModel extends BaseModel implements Serializable {


    /**
     * id : 1
     * title : 工作室老黄历
     * description : 天有不测风云，出门得看黄历
     * creatorId : 1
     * creatorName : marky
     * creatorAvatar : http://cdn.marklux.cn/e303d380-7107-4fb7-9d24-d9f34153a40f
     * subscribed : 125
     * picture : http://cdn.marklux.cn/17-11-9/34478837.jpg
     * createdAt : 0
     * updatedAt : 0
     * isPublic : 1
     * password : null
     * goodPick : 3
     * badPick : 3
     * isSubscribed : false
     * preview : {"calendarName":"工作室老黄历","calendarPicture":"http://cdn.marklux.cn/17-11-9/34478837.jpg","calendarId":1,"good":[{"title":"使用机械键盘","description":"代码敲得更快更准"},{"title":"开小灶","description":"今天适合煮饭"},{"title":"上线服务","description":"不用运维，很稳"}],"bad":[{"title":"开会","description":"会被扣屎盆子背黑锅"},{"title":"写代码","description":"别想了总得写的"},{"title":"合并分支","description":"你将溺死在冲突中"}],"recommend":[{"name":"今日宜吃","items":["美食城二楼","烤肉饭","鹏翔大酒店"]},{"name":"今日宜饮","items":["咖啡爱上茶","","维他柠檬茶"]},{"name":"代码姿势","items":["gay源对面，春光满面"]}]}
     */

    private int id;
    private String title;
    private String description;
    private int creatorId;
    private String creatorName;
    private String creatorAvatar;
    private int subscribed;
    private String picture;
    private Long createdAt;
    private Long updatedAt;
    private int isPublic;
    private Object password;
    private int goodPick;
    private int badPick;
    private boolean isSubscribed;
    private PreviewBean preview;

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

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreatorAvatar() {
        return creatorAvatar;
    }

    public void setCreatorAvatar(String creatorAvatar) {
        this.creatorAvatar = creatorAvatar;
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

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
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

    public PreviewBean getPreview() {
        return preview;
    }

    public void setPreview(PreviewBean preview) {
        this.preview = preview;
    }

    public static class PreviewBean implements Serializable{
        /**
         * calendarName : 工作室老黄历
         * calendarPicture : http://cdn.marklux.cn/17-11-9/34478837.jpg
         * calendarId : 1
         * good : [{"title":"使用机械键盘","description":"代码敲得更快更准"},{"title":"开小灶","description":"今天适合煮饭"},{"title":"上线服务","description":"不用运维，很稳"}]
         * bad : [{"title":"开会","description":"会被扣屎盆子背黑锅"},{"title":"写代码","description":"别想了总得写的"},{"title":"合并分支","description":"你将溺死在冲突中"}]
         * recommend : [{"name":"今日宜吃","items":["美食城二楼","烤肉饭","鹏翔大酒店"]},{"name":"今日宜饮","items":["咖啡爱上茶","","维他柠檬茶"]},{"name":"代码姿势","items":["gay源对面，春光满面"]}]
         */

        private String calendarName;
        private String calendarPicture;
        private int calendarId;
        private List<GoodBean> good;
        private List<BadBean> bad;
        private List<RecommendBean> recommend;

        public String getCalendarName() {
            return calendarName;
        }

        public void setCalendarName(String calendarName) {
            this.calendarName = calendarName;
        }

        public String getCalendarPicture() {
            return calendarPicture;
        }

        public void setCalendarPicture(String calendarPicture) {
            this.calendarPicture = calendarPicture;
        }

        public int getCalendarId() {
            return calendarId;
        }

        public void setCalendarId(int calendarId) {
            this.calendarId = calendarId;
        }

        public List<GoodBean> getGood() {
            return good;
        }

        public void setGood(List<GoodBean> good) {
            this.good = good;
        }

        public List<BadBean> getBad() {
            return bad;
        }

        public void setBad(List<BadBean> bad) {
            this.bad = bad;
        }

        public List<RecommendBean> getRecommend() {
            return recommend;
        }

        public void setRecommend(List<RecommendBean> recommend) {
            this.recommend = recommend;
        }

        public static class GoodBean implements Serializable{
            /**
             * title : 使用机械键盘
             * description : 代码敲得更快更准
             */

            private String title;
            private String description;

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
        }

        public static class BadBean implements Serializable{
            /**
             * title : 开会
             * description : 会被扣屎盆子背黑锅
             */

            private String title;
            private String description;

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
        }

        public static class RecommendBean implements Serializable{
            /**
             * name : 今日宜吃
             * items : ["美食城二楼","烤肉饭","鹏翔大酒店"]
             */

            private String name;
            private List<String> items;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<String> getItems() {
                return items;
            }

            public void setItems(List<String> items) {
                this.items = items;
            }
        }
    }
}
