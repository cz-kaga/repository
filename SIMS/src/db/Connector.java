package db;
public interface Connector {
	Client Connect();
	int Disconnect();
	boolean isConnected();
}
