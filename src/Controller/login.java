package Controller;

import Model.Users;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.regex.*;
import java.util.Map;
@WebServlet("/login")
public class login extends HttpServlet {
    //@Serial
    private static final long serialVersionUID = 1L;

    /**
     * ������ȡ���������ض��ļ���Ӧ��ֵ
     * ���ʣ��ʾ���lambda�����ã�����Ҳ��Ӧ����lambda�����Ծ�ֱ�Ӵֱ��Դ���
     * ��������û��Ū������
     * @param key ��Ҫ��ȡ���ݵļ�
     * @return ����ɹ������ض�Ӧ��ֵ�����ʧ�ܣ����ؿ�
     */
    private String getRequestvalue(String md, String key) {
            String pattern =  "(\"?" + key + "\"?:+ ?\"?)([\\w.]*)\"?,?";    //˭Ҫ�����⴮��������ɱ������
            Pattern r = Pattern.compile(pattern);
            Matcher m =r.matcher(md);
            if (m.find()) {
                return m.group(2);
            } else {
                return null;
            }


    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
        request.setCharacterEncoding("UTF-8");
        String fk;
        try{
            BufferedReader stream = request.getReader();
            fk = stream.readLine();
        }
        catch (IOException ex){
            //TODO
            fk = "uid:gnm";
        }
        String uid = getRequestvalue(fk,"uid");
        String serveraddr = getRequestvalue(fk, "serveraddr");
        String passwd = getRequestvalue(fk,"passwd");
        Users requestuser = new Users();
        try {
            if(requestuser.Login(serveraddr,uid,passwd)) {
                var out = response.getWriter();
                out.write("success");
                out.close();
            }
            else {
                var out = response.getWriter();
                out.write("failed");
                out.close();
            }
        }catch (NullPointerException ex){
            var out = response.getWriter();
            out.write(requestuser.getError()+"|"+requestuser.getServer());
            out.close();
        }


    }

}
