package com;

import javax.servlet.ServletException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Article {
    int id;
    User author;
    String title;
    Image image;
    String body;

    public Article(int id, User author, String title, Image image, String body) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.image = image;
        this.body = body;
    }


    public static Article save(User author, String title, Image image, String body) throws ServletException {
        try(Connection connection = DB.getConnection()) {
            String sql = "INSERT INTO articles (author_id, image_id, title, body) VALUES (?, ?, ?, ?)";
            try(PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
                statement.setInt(1, author.id);
                statement.setInt(2, image.id);
                statement.setString(3, title);
                statement.setString(4, body);

                statement.executeUpdate();
                try(ResultSet result = statement.getGeneratedKeys()){
                    while(result.next()){
                        int id = result.getInt(1);
                        return new Article(id, author, title, image, body);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }

        return null;
    }

    public static Article articleById(int id) throws ServletException {
        try(Connection connection = DB.getConnection()) {
            String sql = "SELECT title, author_id, users.username author_username, image_id, body " +
                    "FROM articles, users WHERE articles.author_id = users.id AND articles.id = ?";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, id);
                try(ResultSet result = statement.executeQuery()){
                    while(result.next()){
                        String title = result.getString("title");
                        int authorId = result.getInt("author_id");
                        String authorUsername = result.getString("author_username");
                        int imageId = result.getInt("image_id");
                        String body = result.getString("body");

                        User author = new User(authorId, authorUsername);
                        Image image = new Image(imageId);
                        return new Article(id, author, title, image, body);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
        return null;
    }

    public static List<Article> getList() throws ServletException {
        List<Article> articleList = new ArrayList<>();
        try(Connection connection = DB.getConnection()) {
            String sql = "SELECT " +
                    "articles.id as article_id, " +
                    "users.id as author_id, " +
                    "users.username as author_username, " +
                    "image_id, " +
                    "title, " +
                    "body " +
                    "FROM articles, users " +
                    "WHERE articles.author_id = users.id " +
                    "ORDER BY articles.id DESC";;
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                try(ResultSet resultSet = statement.executeQuery()){
                    while(resultSet.next()){
                        int articleId = resultSet.getInt("article_id");
                        int authorId = resultSet.getInt("author_id");
                        String authorName = resultSet.getString("author_username");
                        int imageId = resultSet.getInt("image_id");
                        String title = resultSet.getString("title");
                        String body = resultSet.getString("body");

                        User user = new User(authorId, authorName);
                        Image image = new Image(imageId);

                        Article article = new Article(articleId, user, title, image, body);
                        articleList.add(article);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }

        return articleList;
    }
}
