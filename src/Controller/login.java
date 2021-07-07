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
     * 用于提取输入流中特定的键对应的值
     * 别问，问就是lambda不会用，不过也不应该用lambda，所以就直接粗暴对待了
     * 我相信我没有弄疼数据
     * @param key 需要提取数据的键
     * @return 如果成功，返回对应的值，如果失败，返回空
     */
    private String getRequestvalue(String md, String key) {
            String pattern =  "(\"?" + key + "\"?:+ ?\"?)([\\w.]*)\"?,?";    //谁要动了这串东西，我杀他的马
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
