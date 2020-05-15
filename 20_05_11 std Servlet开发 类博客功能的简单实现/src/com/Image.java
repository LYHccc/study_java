package com;

import javax.servlet.ServletException;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.*;

public class Image {
    int id;

    public Image(int id){
        this.id = id;
    }

    //根据用户输入保存图片内容
    public static Image save(Part imagePart) throws IOException, ServletException {
        // 通过 JDBC 保存图片内容
        try (Connection con = DB.getConnection()) {
            String sql = "INSERT INTO images (image) VALUES (?)";
            try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setBlob(1, imagePart.getInputStream(), imagePart.getSize());
                stmt.executeUpdate();

                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        int id = rs.getInt(1);
                        return new Image(id);
                    }

                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    //根据id查找图片信息
    public static byte[] getId(int id) throws ServletException {
        try(Connection connection = DB.getConnection()){
            String sql = "SELECT image FROM images WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, id);
                try(ResultSet resultSet = statement.executeQuery()){
                    while(resultSet.next()){
                        return resultSet.getBytes("image");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
        return null;
    }
}
