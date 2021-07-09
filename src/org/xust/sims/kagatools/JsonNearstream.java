package org.xust.sims.kagatools;

/**
 * ���Ƶ� ���� ��(�ֶ��־�)
 * �����Լ����������д��
 * ��������Json��ʽ������
 * �õ�����д������,�����ûд�ķ���,��һ�����һ�û�õ�
 * ��,����ʵ��Ҳ������(��Ȼ��ֻ����C++�ķ��Ͷ��һ�û����)
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
     * �������POST���������е�json��ʽ����
     * @param key ��������еļ�
     * @param value ����Ӧ��ֵ
     * @return String��ʽ�ַ���,��ʽ��
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
