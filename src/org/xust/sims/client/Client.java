package org.xust.sims.client;
import org.xust.kagatools.GlobalOptions;

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用于实现SQL客户端的类
 * 
 * @author cz_kaga
 * @version 0.0.2
 * 
 */
public class Client  {
	private final static Client INSTANCE = new Client();
	private Connection conn;
	private Statement stmt;
	private static ResultSet rs;
	private String serveraddr;
	private String uid;
	private String passwd;
	private SQLException exception;
	//记得删掉下面这条
	//TODO Delete Order Below!!!!!
	private String wholelink = "jdbc:mysql://localhost:3306/sims?user=root&password=XUST2020&serverTimezone=Asia/Shanghai&characterEncoding=utf-8";
	private Client() {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			 serveraddr = GlobalOptions.CLIENT_HOST;

		} catch (Exception ex) {
				//TODO 启动客户端时驱动注册失败时的行为
			System.out.println("cnmb");
		}
	}

	/**
	 * 提供错误代码与错误情况的
	 * @return 错误代码:错误情况
	 */
	public String getException(){
		String revalue = exception.getErrorCode() + "|" + exception.getSQLState()+"|"+ exception.getMessage();
		exception = exception.getNextException();
		return  revalue;
	}

	public static Client getInstance(){
		return INSTANCE;
	}

	/**
	 * 用于建立Mysql连接
	 * @param aServerside 是原始的服务器地址，比如localhost:3306/test
	 * @param aUserid 原始的用户名，一般为学工号
	 * @param aPasswd 原始密码
	 * @return 成功返回True
	 */
	public Boolean Connect(String aServerside, String aUserid, String aPasswd){

		try {
			serveraddr = aServerside;
			uid = aUserid;
			passwd = aPasswd;
			conn = DriverManager.getConnection(wholelink);
			if(conn.isValid(5)) {
				return Boolean.TRUE;
			}
			else
				return Boolean.FALSE;
		}
		catch (SQLException ex){
			exception = ex;
			//TODO 连接失败时的行为
			return null;
		}



	}

	public Boolean Connect(String aServerside){

		try {

			conn = DriverManager.getConnection(aServerside);
			if(conn.isValid(5)) {
				return Boolean.TRUE;
			}
			else
				return Boolean.FALSE;
		}
		catch (SQLException ex){
			exception = ex;
			//TODO 连接失败时的行为
			return null;
		}



	}

	/**
	 * 检测连接是否仍然可用
	 * @return TRUE 如果连接可用，False 如果连接失效
	 *
	 */
	public Boolean isValid() {
			try{
				if(conn.isValid(10) || Connect(serveraddr,uid,passwd))
					return Boolean.TRUE;
				else
					return Boolean.FALSE;
			}
			catch (SQLException ex){
				return null;
			}

	}

	/**
	 * 清除SQL语句缓存
	 */
	private void clearStatement(){
		stmt = null;
	}

	/**
	 * 清除SQL结果集
	 */
	private void clearResultSet(){
		rs = null;
	}

	/**
	 * 用于提交自定义SQL解释命令
	 * @param method select或insert
	 * @param astmt 完整的命令，需要在Model中组装完成，否则会报错
	 * @return 执行成功返回TRUE,否则返回FALSE,如果执行出错,返回null
	 */
	public Boolean SQL(String method, String astmt) {
		switch (method){
			case "select":
			{
				try {
					if (conn.isValid(10) && Connect(serveraddr, uid, passwd)){
						stmt = conn.createStatement();
						System.out.println(astmt);

						rs = stmt.executeQuery(astmt);

						return Boolean.TRUE;
					}
					else
						return Boolean.FALSE;
				}
				catch (SQLException ex){
					//TODO 当设置的时间为负的时候的处理（当然不可能出现）
					exception=ex;
					System.out.println(getException());
					return null;
				}
			}
			case "insert":	{
				try {
					if (conn.isValid(10) && Connect(serveraddr, uid, passwd)){
						stmt = conn.createStatement();
						System.out.println(astmt);
						return stmt.execute(astmt);
					}
					else
						return Boolean.FALSE;
				}
				catch (SQLException ex){
					//TODO 当设置的时间为负的时候的处理（当然不可能出现）
					exception=ex;
					System.out.println(getException());
					return null;
				}
			}
			default:
				return null;
		}
	}

	/**
	 * 关闭连接
	 * @return TRUE如果正常关闭
	 */
	public boolean disConnect(){
		try{
			if(!conn.isClosed())
				conn.close();
		}
		catch (SQLException fuck){
			//TODO 懂得都懂
		}
		return  Boolean.TRUE;
	}

	public String getServeraddr(){
		return serveraddr;
	}

	/**
	 * 用于插入数据
	 * @param table_name
	 * @param key
	 * @param value
	 * @return
	 */
	public Boolean addInfo(String table_name ,String key, String value){
		try {
			if (conn.isValid(10) || Connect(serveraddr, uid, passwd)){
				stmt = conn.createStatement();
				rs = stmt.executeQuery("INSERT INTO " + table_name + "(" + key + ") VALUES (" + value + ")");
				return Boolean.TRUE;
			}
			else
				return Boolean.FALSE;
		}
		catch (SQLException NegativeTime){
			//TODO 当设置的时间为负的时候的处理（当然不可能出现）
			return null;
		}

	}

	/**
	 *
	 * @param column_name
	 * @param table_name
	 * @param clause
	 * @param n
	 * @param m
	 * @return
	 */
	public Boolean getInfo(String column_name, String table_name, String clause, String n, String m){
		try {
			if (conn.isValid(10) || Connect(serveraddr, uid, passwd)){
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT " + column_name + " FROM " + table_name + " WHERE " + clause + " LIMIT " + n + " OFFSET " + m);
				return Boolean.TRUE;
			}
			else
				return Boolean.FALSE;
		}
		catch (SQLException NegativeTime){
			//TODO 当设置的时间为负的时候的处理（当然不可能出现）
			return null;
		}
	}

	/**
	 *
	 * @param column_name
	 * @param table_name
	 * @param clause
	 * @param n
	 * @return
	 */
	public Boolean getInfo(String column_name, String table_name, String clause, String n){
		try {
			if (conn.isValid(10) || Connect(serveraddr, uid, passwd)){
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT " + column_name + " FROM " + table_name + " WHERE " + clause + " LIMIT " + n );
				return Boolean.TRUE;
			}
			else
				return Boolean.FALSE;
		}
		catch (SQLException NegativeTime){
			//TODO 当设置的时间为负的时候的处理（当然不可能出现）
			return null;
		}
	}

	/**
	 *
	 * @param column_name
	 * @param table_name
	 * @param clause
	 * @return
	 */
	public Boolean getInfo(String column_name, String table_name, String clause){
		try {
			if (conn.isValid(10)|| Connect(serveraddr, uid, passwd)){
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT " + column_name + " FROM " + table_name + " WHERE " + clause);
				return Boolean.TRUE;
			}
			else
				return Boolean.FALSE;
		}
		catch (SQLException NegativeTime){
			//TODO 当设置的时间为负的时候的处理（当然不可能出现）
			return null;
		}
	}

	public ResultSet getRs(){
		return rs;
	}

	public String getFirstResult(){
		try {
			if(rs.next())
				return  rs.getString(1);
			else
				return null;
		}
		catch (SQLException ex) {
			exception = ex;
			System.out.println("cnm");
			return null;
		}
	}

}
