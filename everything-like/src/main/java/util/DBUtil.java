package util;

import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    private static volatile DataSource dataSource;

    /**
     * @return 数据库连接池
     */
    private static DataSource getDataSource(){
        if(dataSource == null){
            synchronized (DBUtil.class){
                if(dataSource == null){
                    SQLiteConfig config = new SQLiteConfig();
                    config.setDateStringFormat(Util.date_pattern);
                    dataSource = new SQLiteDataSource(config);
                    ((SQLiteDataSource)dataSource).setUrl(getUrl());
                }
            }
        }

        return dataSource;
    }

    /**
     * 获取sqlite数据库文件url
     */
    private static String getUrl(){
        //获取target编译文件夹的路径
        //classLoader.getResource默认的根路径为编译文件夹路径(target/classes)
        URL classesURL = DBUtil.class.getClassLoader().getResource("./");
        //获取target/classes文件夹的父目录路径
        String dir = new File(classesURL.getPath()).getParent();
        String url = "jdbc:sqlite://" + dir + File.separator + "everything-like.db";
        //new sqliteDataSource(), 把这个对象的url设置进去，才会创建这个文件
        //如果文件已经存在就会读取这个文件
        System.out.println("获取数据库文件路径" + url);
        return url;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
}
