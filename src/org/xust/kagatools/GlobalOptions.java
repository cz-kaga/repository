package org.xust.kagatools;

/**
 * 仅仅是用来提供全局参数的
 * 你问我为啥放到工具类
 * 因为这个参数之后如果要写东西,肯定通用啊qwq
 * @author cz_kaga
 */
public abstract class GlobalOptions {
    public static String CLIENT_HOST = "localhost";
    public static String USER_NAME;
    public static String USER_ID = "114514";
    public static String SUCCESS_CONTEXT = "success";
    public static String ERROR_CONTEXT = "error";
    public static String FAILED_CONTEXT = "failed";
    public static String DEPLOYED_IP = "127.0.0.1";
    public static String ADMIN_ACCOUNT = "admin";
    public static String ADMIN_PASSWORD = "114514";
    public static String ROOT_PASSWORD = "XUST2020";
    public static String USER_TABLE = "user";
    private  GlobalOptions(){
    }
}
