package app.ver.update;

/**
 * Created by yang on 2018/11/9.
 */

public class VersionCheck {

    /**
     * result : Y
     * error_code : 0
     * error_msg :
     * code : 1
     * msg :
     * data : {"url":"https://www.pgyer.com/FenCangTradeiOS","memo":"修复域名Bug","update_flag":2,"version":"1.6","tittle":"版本更新"}
     */

    private String result;
    private int error_code;
    private String error_msg;
    private int code;
    private String msg;
    private DataBean data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * url : https://www.pgyer.com/FenCangTradeiOS
         * memo : 修复域名Bug
         * update_flag : 2
         * version : 1.6
         * tittle : 版本更新
         */

        private String url;
        private String memo;
        private int update_flag;
        private String version;
        private String tittle;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public int getUpdate_flag() {
            return update_flag;
        }

        public void setUpdate_flag(int update_flag) {
            this.update_flag = update_flag;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getTittle() {
            return tittle;
        }

        public void setTittle(String tittle) {
            this.tittle = tittle;
        }
    }
}
