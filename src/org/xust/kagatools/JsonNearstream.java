package org.xust.kagatools;

import java.sql.SQLException;

/**
 * 自制的 类流 类(手动分句)
 * 按照自己对流的理解写的
 * 用于生成Json格式的数据
 * 用到哪里写到哪里,如果有没写的方法,那一定是我还没用到
 * 对,泛型实现也是这样(虽然我只看了C++的泛型而且还没看懂)
 * @author cz_kaga
 */
public class JsonNearstream {
    private static JsonNearstream session;// = new JsonNearstream();
    private  String content;
    public static JsonNearstream getSession(){
        session = new JsonNearstream();
        return session;
    }
    private JsonNearstream(){

    }
    public JsonNearstream createJson(String key, String value){

        content = "{"+ "\"" + key + "\":\"" + value +"\"";
        return  session;
    }

    /**
     * 用于添加POST返回数据中的json格式数据
     * @param key 添加数据中的键
     * @param value 键对应的值
     * @return 类流
     */
    public  JsonNearstream addJson(String key, String value) {
        content = content +",\"" + key + "\":\"" + value +"\"";
        return session;
    }

    /**
     * 这里模拟了流的终结操作
     * 执行这种终结操作的时候流会被置空
     * @return 类流的字符串形式
     */
    public  String stopJsontoString(){
        String back = content + "}";
        //session = null;
        return back;
    }
}
