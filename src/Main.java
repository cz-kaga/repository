import Database.Client;

import java.sql.DriverManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Main {

	/*
	 * ����ִ��ͷ����ʾ���沢����
	 */
	public static void main(String[] args) {
//		String md ="{\"serveraddr\":\"187.0.0.1\",\"uid\":\"1919810\",\"passwd\":\"1919810\"}";
//		String key = "serveraddr";
//		String pattern =  "(\"?" + key + "\"?:+ ?\"?)([\\w.]*)\"?,?";    //˭Ҫ�����⴮��������ɱ������
//		Pattern r = Pattern.compile(pattern);
//		Matcher m =r.matcher(md);
//		if (m.find()) {
//			System.out.println(m.group(2));
//		}
		try {

			Client dadada=Client.getInstance();
			if(null == dadada.Connect("jdbc:mysql://localhost:3306/test?useSSL=false","1919810","1919810"))
			{
				System.out.println("???");
			}

			System.out.println(dadada.getException());
		} catch (Exception ex) {
			//TODO �����ͻ���ʱ����ע��ʧ��ʱ����Ϊ
			System.out.println("cnmb2");
		}

	}
}
