package org.xust.kagatools;

import java.sql.SQLException;

/**
 * ���Ƶ� ���� ��(�ֶ��־�)
 * �����Լ����������д��
 * ��������Json��ʽ������
 * �õ�����д������,�����ûд�ķ���,��һ�����һ�û�õ�
 * ��,����ʵ��Ҳ������(��Ȼ��ֻ����C++�ķ��Ͷ��һ�û����)
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
     * �������POST���������е�json��ʽ����
     * @param key ��������еļ�
     * @param value ����Ӧ��ֵ
     * @return ����
     */
    public  JsonNearstream addJson(String key, String value) {
        content = content +",\"" + key + "\":\"" + value +"\"";
        return session;
    }

    /**
     * ����ģ���������ս����
     * ִ�������ս������ʱ�����ᱻ�ÿ�
     * @return �������ַ�����ʽ
     */
    public  String stopJsontoString(){
        String back = content + "}";
        //session = null;
        return back;
    }
}
