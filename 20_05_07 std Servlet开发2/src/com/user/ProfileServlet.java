package com.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //首先判断用户是否认证，即是否可以取到session对象
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");
        resp.setContentType("text/plain; charset=utf-8");
        if(user == null){
            // session 中没有取到用户对象,代表用户没有认证过
            resp.getWriter().println("用户没有经过认证，请先进行用户认证");
        }else{
            //打印用户信息
            resp.getWriter().println(user.username);
            resp.getWriter().println(user.nickname);
            resp.getWriter().println(user.balance);
        }
    }
}
