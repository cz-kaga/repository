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
     * ���ڽ����û���¼�ķ���
     * @param auid ѧ����
     * @param apasswd ����
     * @return ����ɹ���¼,����TRUE,���򷵻�FALSE
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
