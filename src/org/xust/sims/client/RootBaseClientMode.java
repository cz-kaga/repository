package org.xust.sims.client;

/**
 * 使用Root超级管理员账户登录数据库
 */
public class RootBaseClientMode extends AdminBaseClientMode {
    private static final RootBaseClientMode modesession = new RootBaseClientMode();
    private RootBaseClientMode(){
        setAccount("root");
        setPassword("XUST2020");
    }

    public RootBaseClientMode getModeSession(){
        return modesession;
    }
}
