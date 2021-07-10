package org.xust.sims.test;

import org.xust.kagatools.GlobalOptions;
import org.xust.sims.client.Client;

public class ClientTest {
    public static void Main(){
        Client session = Client.getInstance();
        if (session.Connect(GlobalOptions.CLIENT_HOST, "root",GlobalOptions.ROOT_PASSWORD)) {
            System.out.println("³É¹¦");
        }
        String column_name = "password";
        String table_name = "user";
        String clause = "uid = 114514";
        System.out.println(session.SQL("select","SELECT " + column_name + " FROM " + table_name + " WHERE " + clause));
    }
}
