package task;

import app.FileMeta;
import util.DBUtil;

import java.io.File;
import java.sql.*;
import java.util.*;

public class FileSave implements ScannerCallBack{
    /**
     * 文件下一级子文件夹和子文件保存到数据库
     * @param dir 根文件目录
     */
    @Override
    public void callBack(File dir) {
        //获取本地子文件
        File[] child = dir.listFiles();
        //保存由File转化为FileMeta的本地子文件
        List<FileMeta> locals = new ArrayList<>();
        if(child != null){
            for(File file : child){
                locals.add(new FileMeta(file));
            }
        }

        //获取数据库中以dir为父目录的子文件
        List<FileMeta> sqlMeta = query(dir);

        //数据库有本地没有，进行删除
        for(FileMeta meta : sqlMeta){
            if(!locals.contains(meta)){
                delete(meta);
            }
        }
        //本地有数据库没有，进行插入
        for(FileMeta meta : locals){
            if(!sqlMeta.contains(meta)){
                save(meta);
            }
        }
    }

    /**
     * 删除meta
     * 1.删除meta本身
     * 2.如果meta是文件夹，删除它的子文件和子文件夹
     * @param meta 要删除的文件夹
     */
    private void delete(FileMeta meta) {
        try(Connection connection = DBUtil.getConnection()) {
            String sql = "delete from file_meta where" +
                    " (name = ? and path = ? and is_directory = ?)";
            //如果是文件夹
            if(meta.isDirectory()){
                sql += " or path = ? or path like ?";
            }
            //System.out.println("删除语句" + sql);
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, meta.getName());
                statement.setString(2, meta.getPath());
                statement.setBoolean(3, meta.isDirectory());
                if(meta.isDirectory()){
                    statement.setString(4, meta.getPath() + File.separator + meta.getName());
                    statement.setString(5, meta.getPath() + File.separator + meta.getName() + File.separator);
                }
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("删除数据库文件信息出错", e);
        }
    }

    /**
     * 查询dir的子文件
     * @param dir 要查询的根目录文件
     * @return 查询的File转化为FileMeta的子文件信息
     */
    private List<FileMeta> query(File dir){
        //保存所有的子文件
        List<FileMeta> list = new ArrayList<>();
        try(Connection connection = DBUtil.getConnection()){
            String sql = "select name, path, size, is_directory, last_modified" +
                    " from file_meta where path = ?";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, dir.getPath());
                try(ResultSet resultSet = statement.executeQuery()){
                    while(resultSet.next()){
                        String name = resultSet.getString("name");
                        String path = resultSet.getString("path");
                        Long size = resultSet.getLong("size");
                        Boolean isDirectory = resultSet.getBoolean("is_directory");
                        Timestamp lastModified = resultSet.getTimestamp("last_modified");

                        FileMeta meta = new FileMeta(name, path, size, isDirectory,
                                new java.util.Date(lastModified.getTime()));
                        //System.out.println("查询文件信息:" + name +"=" + path + "=" + size + "=" + isDirectory + "=" + lastModified);
                        list.add(meta);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询文件信息出错", e);
        }

        return list;
    }

    /**
     * 保存过程
     */
    private void save(FileMeta meta){
        try(Connection connection = DBUtil.getConnection()){
            String sql = "insert into file_meta(" +
                    "name, path, size, is_directory, last_modified, pinyin, pinyin_first)" +
                    " values (?, ?, ?, ?, ?, ?, ?)";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, meta.getName());
                statement.setString(2, meta.getPath());
                statement.setLong(3, meta.getSize());
                statement.setBoolean(4, meta.isDirectory());
                //数据库保存日期类型，可以按数据库设置的日期格式，以字符串传入
                statement.setString(5, meta.getLastModifiedText());
                statement.setString(6, meta.getPinyin());
                statement.setString(7, meta.getPinyinFirst());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("文件保存失败", e);
        }
    }
}
