package Model;

public class Users {
    private final Integer _uid;
    private String _username;
    private String _passwd;
    private UserInfo _info;
    public Users(Integer auid){
        _uid = auid;
    }

    public UserInfo getInfo(Integer _uid){

        return _info;
    }

}
