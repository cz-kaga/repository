package org.xust.sims.controller;


import org.xust.sims.base.GlobalOptions;
import org.xust.sims.model.UserModel;
import org.xust.sims.kagatools.JsonNearstream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;

import static org.xust.sims.kagatools.RegexToString.getRequestvalue;

@WebServlet("/login")
public class UserLoginController extends HttpServlet {

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
        request.setCharacterEncoding("UTF-8");
        String requeststring;
        //这里读取请求data
        try{
            BufferedReader stream = request.getReader();
            requeststring = stream.readLine();
        }
        catch (IOException ex){
            //TODO
            requeststring = "uid:gnm";
        }
        //这里存储读取到的数据
        String uid = getRequestvalue(requeststring,"uid");
        String passwd = getRequestvalue(requeststring,"passwd");
        //这里使用Model处理数据库交互工作
        UserModel requestuser = new UserModel(uid,passwd);
        //不要问为啥是Nearstream,因为我不知道怎么自制一个流,但是我
        //这个nearstream是用stream的思想写的
        JsonNearstream jsondata = JsonNearstream.getSession();
        try {
            if(requestuser.Login(uid,passwd)) {
                response.setContentType("application/json");
                var out = response.getWriter();
                out.write(
                        jsondata
                                .createJson("status", GlobalOptions.SUCCESS_CONTEXT)
                                .addJson("username",uid)
                                .stopJson());
                out.close();
            }
            else {
                var out = response.getWriter();
                out.write(
                        jsondata
                                .createJson("status", GlobalOptions.FAILED_CONTEXT)
                                .stopJson());
                out.close();
            }
        }catch (NullPointerException ex){
            var out = response.getWriter();
            out.write(
                    jsondata
                            .createJson("status", GlobalOptions.ERROR_CONTEXT)
                            .stopJson());
            out.write(requestuser.getError());
            out.close();
        }


    }

}
