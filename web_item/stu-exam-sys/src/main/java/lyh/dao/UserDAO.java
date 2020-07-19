package lyh.dao;

import lyh.model.User;
import lyh.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public static User query(User user) {
        User queryUser = null;

        try (Connection connection = DBUtil.getConnection()){
            String sql =  "select id, nickname from user where username=? and password=?";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getPassword());

                try(ResultSet resultSet = statement.executeQuery()){
                    while(resultSet.next()){
                        queryUser = new User();
                        queryUser.setUsername(user.getUsername());
                        queryUser.setPassword(user.getPassword());
                        queryUser.setId(resultSet.getInt("id"));
                        queryUser.setNickname(resultSet.getString("nickname"));

                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("用户登录操作出错", e);
        }

        return queryUser;
    }
}
