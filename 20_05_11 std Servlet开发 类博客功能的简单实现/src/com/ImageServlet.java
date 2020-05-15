package com;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/image")
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        byte[] buffer = Image.getId(id);

        if(buffer == null){
            resp.sendError(404, "没有这个图片");
            return;
        }

        resp.setContentType("image/jpeg");
        ServletOutputStream os = resp.getOutputStream();
        os.write(buffer);
        os.flush();
    }
}
