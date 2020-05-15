package com;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/list.json")
public class ListAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        List<Article> articleList = Article.getList();
        String jsonText = toJson(articleList);
        resp.getWriter().println(jsonText);
    }

    private String toJson(List<Article> articleList) {
        JSONArray array = new JSONArray();
        for(Article article : articleList){
            JSONObject object = new JSONObject();
            object.put("id", article.id);

            JSONObject author = new JSONObject();
            author.put("id", article.author.id);
            author.put("username", article.author.username);
            object.put("author", author);

            object.put("image_id", article.image.id);
            object.put("image_url", String.format("/image?id=%d", article.image.id));

            object.put("title", article.title);
            object.put("body", article.body);

            array.add(object);
        }
        return array.toJSONString();
    }
}
