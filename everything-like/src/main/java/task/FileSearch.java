package task;

import app.FileMeta;
import util.DBUtil;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FileSearch {

    public static List<FileMeta> search(String dir, String content) {
        List<FileMeta> fileMetas = new ArrayList<>();

        try(Connection connection = DBUtil.getConnection()) {
            String sql = "select name, path, size, is_directory, last_modified from file_meta" +
                    " where (path = ? or path like ?)";
            if(content != null && content.trim().length() != 0){
                sql += " and (name like ? or pinyin like ? or pinyin_first like ?)";
            }
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setString(1, dir);
                ps.setString(2, dir + File.separator + "%");
                if(content != null && content.trim().length() != 0){
                    ps.setString(3, "%" + content + "%");
                    ps.setString(4, "%" + content + "%");
                    ps.setString(5, "%" + content + "%");
                }
                try(ResultSet rs = ps.executeQuery()){
                    while(rs.next()){
                        String name = rs.getString("name");
                        String path = rs.getString("path");
                        Long size = rs.getLong("size");
                        Boolean isDirectory = rs.getBoolean("is_directory");
                        Timestamp lastModified = rs.getTimestamp("last_modified");

                        FileMeta meta = new FileMeta(name, path, size, isDirectory,
                                new java.util.Date(lastModified.getTime()));
                        fileMetas.add(meta);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("数据库查询失败，路径：" + dir + "搜索内容" + content, e);
        }

        return fileMetas;
    }
}
