package org.xust.sims.client;

/**
 * ��Ȩִ����,���벿����Ҫ��Ȩִ�е����
 * ��������δ��¼�鿴��¼�����
 * ���ߵ�¼��Ȩ�޲鿴��Ȩ��������
 * ��ʵ��Ҳ��֪���ⶫ����������
 */
public abstract class BaseClientMode {
    protected final Client session;
    protected String queryhead = "jdbc:mysql://";
    protected String server = "localhost";
    protected String port = "3306";
    protected String table = "sims";
    protected String account;
    protected String password;
    protected String query;




    public BaseClientMode(){
        session = Client.getInstance();
    }

    public Boolean login(){

        session.Connect(queryhead+server+":"+port+"/sims?user="+ account +"&password="+ password +"&serverTimezone=Asia/Shanghai&characterEncoding=utf-8", account, password);
        return session.isValid();
    }


    public Boolean isValid(){
        return session.isValid();
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
