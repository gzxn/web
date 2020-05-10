package com.mb.control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author BabyAngel
 * @date 2020/4/28 - 20:51
 */

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(123456);
        response.setContentType("text/html;charset=utf-8");
        String usename = request.getParameter("username");
        String pwod = request.getParameter("userpwd");
        boolean result = false;
        if (usename!=null&&usename.equals("admin")&&pwod!=null&&pwod.equals("123456")){
            result = true;
        }
        String strHtml = "";
        if (result){
            strHtml = "<!DOCTYPE html>\r\n" +
                    "<html>\r\n" +
                    "<head>\r\n" +
                    "<meta charset=\"UTF-8\">\r\n" +
                    "<title>登录成功</title>\r\n" +
                    "</head>\r\n" +
                    "<body>\r\n" +
                    " <p> 欢迎您："+usename+"</p>\r\n" +
                    "</body>\r\n" +
                    "</html>";
        }else {
            strHtml = "<!DOCTYPE html>\r\n" +
                    "<html>\r\n" +
                    "<head>\r\n" +
                    "<meta charset=\"UTF-8\">\r\n" +
                    "<title>登录失败</title>\r\n" +
                    "</head>\r\n" +
                    "<body>\r\n" +
                    " <p> 用户名或者密码错误，<a href=\"login.html\">请重新登录</a> </p>\r\n" +
                    "</body>\r\n" +
                    "</html>";
        }
        PrintWriter out = response.getWriter();
        out.println(strHtml);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

