package com.nequer.android.business.subscribe.mvp.model;

import java.io.Serializable;
import java.util.List;

public class CalendarModel implements Serializable {

    /**
     * calendarName : 拆迁⑥黄历
     * calendarPicture : http://cdn.marklux.cn/08404141-5447-42a4-9e43-3ed7ce7a0871
     * calendarId : 149
     * good : [{"title":"玩韩国欧巴","description":"隐身偷人"},{"title":"打PVP","description":"场场3比0"}]
     * bad : [{"title":"玩人质局","description":"打进攻队友选fuze"},{"title":"用女武神","description":"扔黑眼被人打"}]
     * recommend : [{"name":"\u2026\u2026\u2026\u2026","items":["\u2026\u2026"]}]
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

    public static class GoodBean implements Serializable {
        /**
         * title : 玩韩国欧巴
         * description : 隐身偷人
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
         * title : 玩人质局
         * description : 打进攻队友选fuze
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
         * name : …………
         * items : ["\u2026\u2026"]
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
