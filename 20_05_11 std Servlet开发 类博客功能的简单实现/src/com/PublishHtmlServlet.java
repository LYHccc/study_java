package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/publish.html")
public class PublishHtmlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取当前用户登录信息
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        //如果没有登录跳转到登录页面
        if(user == null){
            resp.sendRedirect("/login.html");
        }

        String htmlContent = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>发表文章</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>发表文章</h1>\n" +
                "    <a href=\"/logout\">退出</a>\n" +
                "    <form method=\"post\" action=\"/publish\" enctype=\"multipart/form-data\">\n" +
                "        <div>\n" +
                "            <label>图片</label>\n" +
                "            <input type=\"file\" name=\"image\">\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <label>标题</label>\n" +
                "            <input type=\"text\" name=\"title\">\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <label>正文</label>\n" +
                "            <textarea name=\"body\"></textarea>\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <button type=\"submit\">发表</button>\n" +
                "        </div>\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>";
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().println(htmlContent);
    }
}
