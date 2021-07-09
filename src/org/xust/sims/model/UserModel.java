package org.xust.sims.model;

import org.xust.sims.base.Client;
import org.xust.sims.base.GlobalOptions;

public class UserModel {
    private String uid;
    private String passwd;
    private UserInfoModel info;
    private final Client session = Client.getInstance();
    public UserModel(String auid, String apasswd){
        uid = auid;
        GlobalOptions.USER_ID = uid;
        passwd = apasswd;
    }

    public UserInfoModel getInfo(Integer _uid){

        return info;
    }

    /**
     * 用于进行用户登录的方法
     * @param auid 学工号
     * @param apasswd 密码
     * @return 如果成功登录,返回TRUE,否则返回FALSE
     */
    public Boolean Login(String auid, String apasswd){
        GlobalOptions.USER_ID = auid;
        passwd = apasswd;
        return session.Connect(GlobalOptions.CLIENT_HOST, GlobalOptions.USER_ID,passwd);

    }

    public String getError(){
        return session.getException();
    }



}
