package Bean;

import cn.bmob.v3.BmobObject;

public class UserBean extends BmobObject {
    private String REGISTTIME = "";//用户注册时间
    private String USERREGISTINFO = "";//用户注册信息

    public String getREGISTTIME() {
        return REGISTTIME;
    }

    public void setREGISTTIME(String REGISTTIME) {
        this.REGISTTIME = REGISTTIME;
    }

    public String getUSERREGISTINFO() {
        return USERREGISTINFO;
    }

    public void setUSERREGISTINFO(String USERREGISTINFO) {
        this.USERREGISTINFO = USERREGISTINFO;
    }
}
