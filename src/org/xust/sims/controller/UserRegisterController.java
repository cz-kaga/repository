package org.xust.sims.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.xust.kagatools.GlobalOptions;
import org.xust.kagatools.JsonNearstream;
import org.xust.kagatools.RegexToString;
import org.xust.sims.model.UserModel;

import java.io.*;


@WebServlet("/register")
public class UserRegisterController extends BaseController{

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        String requeststring = getRequeststring(request, response);
        //����洢��ȡ��������
        String uid = RegexToString.getRequestvalue(requeststring,"uid");
        String username = RegexToString.getRequestvalue(requeststring,"username");
        String passwd = RegexToString.getRequestvalue(requeststring,"passwd");
        //����ʹ��Model�������ݿ⽻������
        UserModel requestuser = new UserModel(uid,passwd);
        //��Ҫ��Ϊɶ��Nearstream,��Ϊ�Ҳ�֪����ô����һ����,������
        //���nearstream����stream��˼��д��
        JsonNearstream jsondata = JsonNearstream.getSession();
        try {
            if(requestuser.Register(uid,passwd,username)) {
                response.setContentType("application/json");
                var out = response.getWriter();
                out.write(
                        jsondata
                                .createJson("status", GlobalOptions.SUCCESS_CONTEXT)
                                .addJson("username",uid)
                                .stopJsontoString());
                out.close();
            }
            else {
                var out = response.getWriter();
                out.write(
                        jsondata
                                .createJson("status", GlobalOptions.FAILED_CONTEXT)
                                .stopJsontoString());
                out.close();
            }
        }catch (NullPointerException ex){
            var out = response.getWriter();
            out.write(
                    jsondata
                            .createJson("status", GlobalOptions.ERROR_CONTEXT)
                            .addJson("errorinfo",requestuser.getError())
                            .stopJsontoString());
            out.close();
        }
    }
}
