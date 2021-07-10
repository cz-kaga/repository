package org.xust.sims.controller;


import org.xust.kagatools.GlobalOptions;
import org.xust.kagatools.JsonNearstream;
import org.xust.kagatools.RegexToString;
import org.xust.sims.model.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet("/login")
public class UserLoginController extends BaseController {

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
        String requeststring = getRequeststring(request, response);
        //这里存储读取到的数据
        String uid = RegexToString.getRequestvalue(requeststring,"uid");
        String passwd = RegexToString.getRequestvalue(requeststring,"passwd");
        //这里使用Model处理数据库交互工作
        UserModel requestuser = new UserModel(uid,passwd);
        //不要问为啥是Nearstream,因为我不知道怎么自制一个流,但是我
        //这个nearstream是用stream的思想写的
        JsonNearstream jsondata = JsonNearstream.getSession();
//        try {
            if(requestuser.Login(uid,passwd)) {
                response.setContentType("application/json");
                var out = response.getWriter();
                out.write(
                        jsondata
                                .createJson("status", GlobalOptions.SUCCESS_CONTEXT)
                                .addJson("username",GlobalOptions.USER_NAME)
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
//        }
//        catch (NullPointerException ex){
//            var out = response.getWriter();
//            out.write(
//                    jsondata
//                            .createJson("status", GlobalOptions.ERROR_CONTEXT)
//                            .addJson("errorinfo",requestuser.getError())
//                            .stopJsontoString());
//            out.close();
//        }


    }

}
