package org.xust.sims.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class BaseController extends HttpServlet {

    public String getRequeststring(HttpServletRequest request, HttpServletResponse response)throws IOException{
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
        return requeststring;
    }
}
