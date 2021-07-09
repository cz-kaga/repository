package org.xust.sims.kagatools;

/**
 * 自制的 类流 类(手动分句)
 * 按照自己对流的理解写的
 * 用于生成Json格式的数据
 * 用到哪里写到哪里,如果有没写的方法,那一定是我还没用到
 * 对,泛型实现也是这样(虽然我只看了C++的泛型而且还没看懂)
 * @author cz_kaga
 */
public class JsonNearstream {
    private static final  JsonNearstream session = new JsonNearstream();
    private  String content;
    public static JsonNearstream getSession(){
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
     * @return String格式字符串,格式是
     */
    public  JsonNearstream addJson(String key, String value) {
        content = content +",\"" + key + "\":\"" + value +"\"";
        return session;
    }

    public  String stopJson(){
        content = content + "}";
        return content;
    }
}
