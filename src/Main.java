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
	 * 程序执行头，显示界面并进行
	 */
	public static void main(String[] args) {
//		String md ="{\"serveraddr\":\"187.0.0.1\",\"uid\":\"1919810\",\"passwd\":\"1919810\"}";
//		String key = "serveraddr";
//		String pattern =  "(\"?" + key + "\"?:+ ?\"?)([\\w.]*)\"?,?";    //谁要动了这串东西，我杀他的马
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
			//TODO 启动客户端时驱动注册失败时的行为
			System.out.println("cnmb2");
		}

	}
}
