package db;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 用户的接口类,提供连接,断连,以及获取基本信息的功能
 * 
 * @author cz_kaga
 * @version 0.0.1
 */
public interface User {
	Client Connect();

	int Disconnect();

	boolean isConnected();

	String getIdentity();

	String getName();

	String getId();

	Collection<Integer> getSubjectid();

	ArrayList<String> getSubjectname();

	String getInfo();
}
