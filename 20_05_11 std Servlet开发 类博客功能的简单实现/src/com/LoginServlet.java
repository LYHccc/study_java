package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.读取用户输入
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2.合法性校验
        if(username == null){
            System.out.println("用户名必须填写");
            resp.sendRedirect("/login.html");
            return;
        }

        //3.在数据库中查找
        User user = User.getUsers(username, password);

        //4.写入Session登录
        HttpSession session = req.getSession();
        session.setAttribute("user", user);

        //5.跳转到文章发布页面
        resp.sendRedirect("publish.jsp");
    }
}
