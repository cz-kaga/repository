package db;

import com.mysql.cj.jdbc.*;
import locale.Locale;

public static class MysqlClient extends Client {
	private static MysqlClient _Session;

	public MysqlClient() {
		_Session = new MysqlClient();

	}

	public MysqlClient Connect() {
		return _Session;
	}
}
