package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Notice, do not import com.mysql.cj.jdbc.*
// or you will have problems!


/**
 * 用于实现SQL客户端的类
 * 
 * @author cz_kaga
 * @version 0.0.2
 * 
 */
public class Client  {
	private final static Client _instance = new Client();
	private Connection _conn = null;
	private Statement _stmt = null;
	private ResultSet _rs = null;
	private String _serveraddr = null;
	private String _uid = null;
	private String _passwd = null;
	private SQLException _exception = null;
	private Client() {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

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
		String revalue =_exception.getErrorCode() + "|" + _exception.getSQLState()+"|"+_exception.getMessage();
		_exception = _exception.getNextException();
		return  revalue;
	}

	public static Client getInstance(){
		return _instance;
	}

	/**
	 * 用于建立Mysql连接
	 * @param aServerside 是原始的服务器地址，比如localhost:3306/test
	 * @param aUserid 原始的用户名，一般为学工号
	 * @param aPasswd 原始密码
	 * @return 成功返回True
	 */
	public Boolean Connect(String aServerside, String aUserid, String aPasswd){
		String serverside =  aServerside;

		try {
			_serveraddr = aServerside;
			_uid = aUserid;
			_passwd = aPasswd;

				_conn = DriverManager.getConnection(serverside);
			if(_conn == null) {
				return Boolean.TRUE;
			}
			else
				return Boolean.FALSE;
		}
		catch (SQLException ex){
			_exception = ex;
			//TODO 连接失败时的行为
			return null;
		}



	}

	/**
	 * 检测连接是否仍然可用
	 * @return TRUE 如果连接可用，False 如果连接失效
	 * @deprecated 请使用Connection.isValid，我是傻逼
	 */
	private boolean isValid(){
		try{
			_stmt = _conn.createStatement();
			_rs = _stmt.executeQuery("SELECT 1");
			clearStatement();
			clearResultSet();
			return  Boolean.TRUE;
		}
		catch (SQLException ex){
			clearStatement();
			clearResultSet();
			return Boolean.FALSE;
		}
	}

	/**
	 * 清除SQL语句缓存
	 */
	private void clearStatement(){
		_stmt = null;
	}

	/**
	 * 清除SQL结果集
	 */
	private void clearResultSet(){
		_rs = null;
	}

	/**
	 * 用于提交SQL解释命令
	 * @param astmt 完整的命令，需要在Model中组装完成，否则会报错
	 * @return ResultSet类型 为结果集，如果连接失效，返回null
	 */
	public ResultSet SQL(String astmt) {
		try {
			if (_conn.isValid(10) && Connect(_serveraddr,_uid,_passwd)){
				_stmt = _conn.createStatement();
				_rs = _stmt.executeQuery(astmt);
				return _rs;
			}
			else
				return null;
		}
		catch (SQLException NegativeTime){
			//TODO 当设置的时间为负的时候的处理（当然不可能出现）
		}
		return null;
	}

	/**
	 * 关闭连接
	 * @return TRUE如果正常关闭
	 */
	public boolean disConnect(){
		try{
			if(!_conn.isClosed())
				_conn.close();
		}
		catch (SQLException fuck){
			//TODO 懂得都懂
		}
		return  Boolean.TRUE;
	}

	public String getServeraddr(){
		return _serveraddr;
	}

}
