package org.xust.sims.test;

import org.xust.kagatools.GlobalOptions;
import org.xust.kagatools.JsonNearstream;
import org.xust.kagatools.SQLNearstream;
import org.xust.sims.client.AdminBaseClientMode;
import org.xust.sims.client.Client;

public class Main {
    public static void main(String args[]){
        JsonNearstream jsondata = JsonNearstream.getSession();
        AdminBaseClientMode admin = new AdminBaseClientMode();
        Client session = Client.getInstance();
        SQLNearstream stream = SQLNearstream.getInstance();
        String password = "1919810";
        System.out.println(stream.createSelect("password", GlobalOptions.USER_TABLE)
                .addSelectWhere("uid" + " = " + GlobalOptions.USER_ID)
                .stopSQLtoString());
        System.out.println(admin.userLogin("1919810"));
        if(session.SQL("select",
                stream.createSelect("password", GlobalOptions.USER_TABLE)
                        .addSelectWhere("uid" + " = " + GlobalOptions.USER_ID)
                        .stopSQLtoString()
        )&& session.getFirstResult().equals(password)){
            session.SQL("select",
                    stream.createSelect("username",GlobalOptions.USER_TABLE)
                            .addSelectWhere("uid" + "=" + GlobalOptions.USER_ID)
                            .stopSQLtoString());
            System.out.println(GlobalOptions.USER_NAME = session.getFirstResult());


        }




    }
}
