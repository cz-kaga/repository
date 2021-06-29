package db;

/**
 * 用于实现SQL客户端的基类
 * 
 * @author cz_kaga
 * @version 0.0.1
 * 
 */
public abstract class Client implements User {
	private String _Clientname;
	private String _ServerAddr;
	private String _UserAccount;
	private String _Passwd;
	private String _Identity;
	private String _Version;

	public Client() {
		_Clientname = "SIMS - XUST";
		_ServerAddr = "Localhost";
		_UserAccount = null;
		_Passwd = null;
		_Identity = null;
	}

	public String getClinetname() {
		return _Clientname;
	};

	public String getServerAddr() {
		return _ServerAddr;
	}

	public String getUserAccount() {
		return _UserAccount;
	}

	public String getIdentity() {
		return _Identity;
	}

	public String getVersion() {
		return _Version;
	}

	protected String getPasswd() {return _Passwd;}
}
