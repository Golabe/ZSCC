package com.zspt.app.modulemain.launcher.model;

/**
 * Created by yuequan on 2017/10/16.
 */

public class LauncherModel {


    /**
     * code : 200
     * message : success
     * data : {"id":"00000","imageUrl":"http://img.hb.aicdn.com/c02b6eb3db2c52de4f147e0aab18707e94da31fb497b3-Jk1vne_fw658","details":"哈哈哈"}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 00000
         * imageUrl : http://img.hb.aicdn.com/c02b6eb3db2c52de4f147e0aab18707e94da31fb497b3-Jk1vne_fw658
         * details : 哈哈哈
         */

        private String id;
        private String imageUrl;
        private String details;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }
}
