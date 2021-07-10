package org.xust.kagatools;

/**
 * ���Ƶ� ���� ��(�ֶ��־�)
 * �����Լ����������д��
 * ��������SQL���������
 * �õ�����д������,�����ûд�ķ���,��һ�����һ�û�õ�
 * ��,����ʵ��Ҳ������(��Ȼ��ֻ����C++�ķ��Ͷ��һ�û����)
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
     * ���ڴ���һ����ѯ���
     * ���Ǵ�������
     * ֪����֪����,���Ͷ�̬�пվ�д
     * @param col_name Ҫ���ҵ�����
     * @param table Ҫ���ҵı�
     * @return һ������
     */
    public SQLNearstream createSelect(String col_name, String table){
        //session = new SQLNearstream();
        session.content = "SELECT "+ col_name + " FROM " + table;
        return  session;
    }


    /**
     * ������SELECT�����м���WHERE�����޶�
     * @param clause ����,һ���������ʽ
     * @return һ������
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
     * ����ģ���������ս����
     * ִ�������ս������ʱ�����ᱻ�ÿ�
     * �ø�ƨ������ÿպ��Ҳ���4Сʱ����
     * @return �������ַ�����ʽ
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
