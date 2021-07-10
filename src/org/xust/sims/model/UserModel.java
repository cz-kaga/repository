package org.xust.sims.model;

import org.xust.sims.client.AdminBaseClientMode;
import org.xust.sims.client.Client;
import org.xust.kagatools.GlobalOptions;

public class UserModel {
    private AdminBaseClientMode admin;
    private String uid;
    private String passwd;
    private UserInfoModel info;
    private final Client session = Client.getInstance();
    public UserModel(String auid, String apasswd){
        admin = new AdminBaseClientMode();
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
        return admin.userLogin(passwd);

    }
    public Boolean Register(String auid, String apassword, String ausername){
        GlobalOptions.USER_ID = auid;
        passwd = apassword;
        GlobalOptions.USER_NAME = ausername;
        return Boolean.TRUE;
    }

    public String getError(){
        return session.getException();
    }



}
