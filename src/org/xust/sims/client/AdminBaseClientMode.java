package org.xust.sims.client;

import org.xust.kagatools.GlobalOptions;
import org.xust.kagatools.SQLNearstream;

/**
 * 特权执行类,用于部分需要在用户表执行的情况
 * 该类用于注册与登录
 * 其实我也不知道这东西拿来干嘛
 */
public class AdminBaseClientMode extends BaseClientMode{

    public AdminBaseClientMode(){
        account = "root";
        password = "XUST2020";
    }
    public Boolean userLogin(String password){
        SQLNearstream stream = SQLNearstream.getInstance();
        if(login()){
            //System.out.println(session.isValid());
            try {
                if(session.isValid() && session.SQL("select",
                        stream.createSelect("password", GlobalOptions.USER_TABLE)
                        .addSelectWhere("uid" + " = " + GlobalOptions.USER_ID)
                        .stopSQLtoString()
                )&& session.getFirstResult().equals(password)){
                    session.SQL("select",
                            stream.createSelect("username",GlobalOptions.USER_TABLE)
                            .addSelectWhere("uid" + "=" + GlobalOptions.USER_ID)
                            .stopSQLtoString());
                    //System.out.println("789");
                    GlobalOptions.USER_NAME = session.getFirstResult();
                    return Boolean.TRUE;
                }
                else
                    return Boolean.FALSE;

            }catch (NullPointerException ex){
                return Boolean.FALSE;
            }
        }
        return Boolean.FALSE;

    }

    public Boolean userRegister(String password){
        SQLNearstream stream = SQLNearstream.getInstance();
        if(login()){
            if(session.isValid()&&session.SQL("insert",
                    stream.createInsert(GlobalOptions.USER_TABLE,"uid")
                    .addInsertKey("username")
                    .addInsertKey("password")
                    .startInsertValue(GlobalOptions.USER_ID)
                    .addInsertValue(GlobalOptions.USER_NAME)
                    .addInsertValue(password)
                    .closeInsert())){
                
            }
        }

    }

}
