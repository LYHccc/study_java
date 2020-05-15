package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.读取用户提交的信息
        //设置字符集编码
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2.验证用户合法性
        if(username == null){
            System.out.println("用户名必须填写");
            resp.sendRedirect("/register.html");
            return;
        }
        //3.保存到数据库User表中
        User user = User.insert(username, password);

        //4.利用Session进行用户登录
        HttpSession session = req.getSession();
        session.setAttribute("user", user);

        //5.跳转到发表文章界面
        resp.sendRedirect("/publish.jsp");
    }
}
