package task;

import util.DBUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 1.初始化数据库:约定好数据库文件放在target/everything-like.db
 * 如果没有就初始化,调用DBUtil.getConnection()就可以初始化
 * 2.并读取sql文件
 * 3.执行sql语句初始化表
 */
public class DBInit {
    /**
     * 获取sql语句
     * @return 数组中每一个元素，就是一条sql语句
     */
    public static String[] readSql(){
        //通过classLoader获取流
        InputStream is = DBInit.class.getClassLoader().getResourceAsStream("init.sql");
        //保存去掉注释后的所有sql语句
        StringBuilder str = new StringBuilder();
        try {
            //字节流转换为字符流
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line;
            while((line = br.readLine()) != null){
                //去除注释--
                if(line.contains("--")){
                    line = line.substring(0, line.indexOf("--"));
                }
                str.append(line);
            }
            String[] sqls = str.toString().split(";");
            return sqls;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("获取sql语句出错", e);
        }
    }

    /**
     * 执行sql语句，初始化表
     */
    public static void init(){
        try(Connection connection = DBUtil.getConnection()) {
            try(Statement statement = connection.createStatement()){
                for (String sql : readSql()) {
                    statement.executeUpdate(sql);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("初始化数据库表结构失败", e);
        }
    }
}
