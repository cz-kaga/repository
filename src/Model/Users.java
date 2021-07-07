package Model;

import Database.Client;

public class Users {
    private String _serveraddress;
    private String _uid;
    private String _username;
    private String _passwd;
    private UserInfo _info;
    private String _port;
    private String _query;
    Client Csession = Client.getInstance();
    public  Users(){

    }

    public UserInfo getInfo(Integer _uid){

        return _info;
    }
    public Boolean Login(String serveraddr, String auid, String apasswd){

        _serveraddress = serveraddr;
        _uid = auid;
        _passwd = apasswd;
        _port ="3306";
        _query = "jdbc:mysql://"+_serveraddress+":"+_port+"/sims?user="+_uid+"&password="+_passwd+"&serverTimezone=Asia/Shanghai&characterEncoding=utf-8&useSSL=false";
        return  Csession.Connect(_query,_uid,_passwd);
    }
    public String getError(){
        return Csession.getException();
    }
    public String getServer(){
        return Csession.getServeraddr();
    }

}
