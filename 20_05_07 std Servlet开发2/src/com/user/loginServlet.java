package com.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        resp.setContentType("text/plain; charset=utf-8");

        User user = UserTable.select(username, password);
        if(user == null){
            System.out.println("认证失败");
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.getWriter().println("用户认证成功，请进行下一步操作");
        }
    }
}
