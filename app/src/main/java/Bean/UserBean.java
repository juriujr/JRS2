package Bean;

import cn.bmob.v3.BmobObject;

public class UserBean extends BmobObject {
    private String REGISTTIME = "";//用户注册时间
    private String USERREGISTINFO = "";//用户注册信息
    private String REGISTUSERNAME = "";//用户注册名
    private String REGISTUSERPASS = "";//用户密码

    public String getREGISTUSERNAME() {
        return REGISTUSERNAME;
    }

    public void setREGISTUSERNAME(String REGISTUSERNAME) {
        this.REGISTUSERNAME = REGISTUSERNAME;
    }

    public String getREGISTUSERPASS() {
        return REGISTUSERPASS;
    }

    public void setREGISTUSERPASS(String REGISTUSERPASS) {
        this.REGISTUSERPASS = REGISTUSERPASS;
    }

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
