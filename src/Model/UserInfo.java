package Model;

import java.util.Date;
import java.util.List;

public class UserInfo {
    private String _sex;
    private String _college;
    private Date _accessdate;
    private String _degree;
    private Integer _age;
    private List<String> _choosedclass;
    private List<String> _class;
    private String _type;

    public String getSex(){
        return _sex;
    }

    public String getCollege(){
        return _college;
    }

    public String getDegree(){
        return _degree;
    }

    public String getType(){
        return _type;
    }

    public Date getAccessdate(){
        return _accessdate;
    }

    public List<String> getClassname(){
        return _class;
    }

    public List<String> getChoosedclass(){
        return _choosedclass;
    }

    public Integer getAge(){
        return _age;
    }
}
