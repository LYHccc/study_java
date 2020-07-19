package lyh.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil{
    private static volatile DataSource dataSource;
    private static final String url = "jdbc:mysql://localhost:3306/stu_exam";
    private static final String username = "root";
    private static final String password = "";

    private DBUtil(){}

    private static DataSource getDataSource(){
        if(dataSource == null){
            synchronized (DBUtil.class){
                if(dataSource == null){
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource) dataSource).setUrl(url);
                    ((MysqlDataSource) dataSource).setUser(username);
                    ((MysqlDataSource) dataSource).setPassword(password);
                }
            }
        }

        return dataSource;
    }

    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("获取连接失败", e);
        }
    }

    public static void close(Connection connection, Statement statement){
        close(connection, statement, null);
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("释放资源失败", e);
        }
    }
}