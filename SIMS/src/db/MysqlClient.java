package db;
import com.mysql.cj.jdbc.*;
public static class MysqlClient extends Client {
	private static MysqlClient _Session = new MysqlClient();
	public MysqlClient  Connect()
	{
		return _Session;
	}
}
