package db;
public abstract class Client implements Connector{
	private char _Clientname;
	private char _ServerAddr;
	private char _UserAccount;
	private char _Passwd;
	private char _Identity;
	public char getClinetname()
	{
		return _Clientname;
	};
	public char getServerAddr()
	{
		return _ServerAddr;
	}
	public char getUserAccount()
	{
		return _UserAccount;
	}
	public char getIdentity()
	{
		return _Identity;
	}
}
