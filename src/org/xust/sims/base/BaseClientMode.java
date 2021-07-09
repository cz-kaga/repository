package org.xust.sims.base;

public abstract class BaseClientMode {
    private final Client Session;
    private String queryhead = "jdbc:mysql://";
    private String server = "localhost";
    private String port = "3306";
    private String table = "sims";
    private String account;
    private String password;
    private String query;




    public BaseClientMode(){
        Session = Client.getInstance();
    }

    public Boolean login(){
        return Session.Connect(queryhead+server+":"+port+"/sims?user="+ account +"&password="+ password +"&serverTimezone=Asia/Shanghai&characterEncoding=utf-8", account, password);
    }


    public Boolean isValid(){
        return Session.isValid();
    }

    public void setServer(String aserver){
        server = aserver;
    }

    public void setPort(String aport){
        port = aport;
    }

    public void setTable(String atable){
        table = atable;
    }

    public void setAccount(String aaccount){
        account = aaccount;
    }

    public void setPassword(String apassword){
        password = apassword;
    }

    public String getServer(){
        return server;
    }

    public String getAccount(){
        return account;
    }

    public String getPassword(){
        return password;
    }

    public String getTable(){
        return table;
    }

}
