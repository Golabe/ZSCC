package com.zspt.app.modulelogin.model;

import java.util.List;

/**
 * Created by yuequan on 2017/10/17.
 */

public class ForgotModel {

    /**
     * status : 1
     * message : ok
     * data : [{"catid":0,"catname":"首页"},{"catid":1,"catname":"综艺"},{"catid":2,"catname":"明星"},{"catid":3,"catname":"韩娱"},{"catid":4,"catname":"看点"}]
     */

    private int status;
    private String message;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * catid : 0
         * catname : 首页
         */

        private int catid;
        private String catname;

        public int getCatid() {
            return catid;
        }

        public void setCatid(int catid) {
            this.catid = catid;
        }

        public String getCatname() {
            return catname;
        }

        public void setCatname(String catname) {
            this.catname = catname;
        }
    }
}
