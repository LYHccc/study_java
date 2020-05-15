package com;

import javax.servlet.ServletException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class User {
    int id;
    String username;

    public User(int id, String username){
        this.id = id;
        this.username = username;
    }

    public static User insert(String username, String password) throws ServletException {
        //1.对密码进行hash处理（这里使用 sha256 算法)
        password = encrypt(password);
        try(Connection connection = DB.getConnection()) {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            try(PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                statement.setString(1, username);
                statement.setString(2, password);

                statement.executeUpdate();

                try(ResultSet result = statement.getGeneratedKeys()){
                    if(result.next()){
                        int id = result.getInt(1);
                        return new User(id, username);
                    }
                }
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }

        return null;
    }

    //// 利用 SHA-256 算法，给密码做 hash 处理
    public static String encrypt(String password){
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] input = password.getBytes("UTF-8");
            byte[] output = messageDigest.digest(input);

            StringBuilder str = new StringBuilder();
            for(byte b : output){
                str.append(String.format("%02x", b));
            }
            return str.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return password;
        }
    }

    public static User getUsers(String username, String password) throws ServletException {
        //1.对密码进行hash处理（这里使用 sha256 算法)
        password = encrypt(password);

        try(Connection connection = DB.getConnection()){
            String sql = "SELECT id FROM users WHERE username = ? AND password = ?";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, username);
                statement.setString(2, password);

                try(ResultSet result = statement.executeQuery()){
                    while(result.next()){
                        int id = result.getInt(1);
                        return new User(id, username);
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
