package org.xust.kagatools;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ��������������ʽ��ȡ�ַ����Ĺ�����
 * �޷�ʵ����
 * @author cz_kaga
 */
public class RegexToString {
    private RegexToString(){

    }
    /**
     * ������ȡ�����������ض��ļ���Ӧ��ֵ
     * ���ʣ��ʾ���lambda�����ã�����Ҳ��Ӧ����lambda�����Ծ�ֱ�Ӵֱ��Դ���
     * ��������û��Ū������
     * @param key ��Ҫ��ȡ���ݵļ�
     * @return ����ɹ������ض�Ӧ��ֵ�����ʧ�ܣ����ؿ�
     */
    public static String getRequestvalue(String md, String key) {
        String pattern =  "(\"?" + key + "\"?:+ ?\"?)([\\w.]*)\"?,?";    //˭Ҫ�����⴮��������ɱ������
        Pattern r = Pattern.compile(pattern);
        Matcher m =r.matcher(md);
        if (m.find()) {
            return m.group(2);
        } else {
            return null;
        }
    }

}
