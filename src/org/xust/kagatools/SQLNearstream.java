package org.xust.kagatools;

/**
 * 自制的 类流 类(手动分句)
 * 按照自己对流的理解写的
 * 用于生成SQL命令的数据
 * 用到哪里写到哪里,如果有没写的方法,那一定是我还没用到
 * 对,泛型实现也是这样(虽然我只看了C++的泛型而且还没看懂)
 * @author cz_kaga
 */
public class SQLNearstream {
    private static SQLNearstream session;// = new SQLNearstream();
    private String content;

    public static SQLNearstream getInstance(){
        session = new SQLNearstream();
        return session;
    }
    private SQLNearstream(){

    }

    /**
     * 用于创建一个查询语句
     * 这是创建方法
     * 知道了知道了,泛型多态有空就写
     * @param col_name 要查找的列名
     * @param table 要查找的表
     * @return 一个类流
     */
    public SQLNearstream createSelect(String col_name, String table){
        //session = new SQLNearstream();
        session.content = "SELECT "+ col_name + " FROM " + table;
        return  session;
    }


    /**
     * 用于在SELECT类流中加入WHERE条件限定
     * @param clause 条件,一个布尔表达式
     * @return 一个类流
     */
    public SQLNearstream addSelectWhere(String clause) {
        content = content + " WHERE " + clause;
        return session;
    }


    public SQLNearstream addSelectLimit(String n){
        content = content + " LIMIT " + n;
        return session;
    }

    /**
     * 这里模拟了流的终结操作
     * 执行这种终结操作的时候流会被置空
     * 置个屁啊这个置空害我查了4小时报错
     * @return 类流的字符串形式
     */
    public  String stopSQLtoString(){
        String back = content;
        //session = null;
        return back;
    }

    public SQLNearstream createInsert(String table, String key){
        content = "INSERT INTO " + table + " (" + key;
        return session;
    }

    public SQLNearstream addInsertKey(String key){
        content = content + "," + key;
        return session;
    }

    public SQLNearstream startInsertValue(String value){
        content = content + ") VALUES (\"" + value + "\"";
        return session;
    }
    public SQLNearstream startInsertValue(Integer value){
        content = content + ") VALUES (" + value;
        return session;
    }
    public SQLNearstream addInsertValue(String value){
        content = content + ", \"" + value + "\"";
        return session;
    }
    public SQLNearstream addInsertValue(Integer value){
        content = content + ", " + value;
        return session;
    }
    public String closeInsert(){
        content = content + ")";
        return content;
    }
}
