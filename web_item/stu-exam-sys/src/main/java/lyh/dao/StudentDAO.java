package lyh.dao;

import lyh.model.DictionaryTag;
import lyh.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public static List<DictionaryTag> queryAsDict(int id) {
        List<DictionaryTag> tags = new ArrayList<>();

        try (Connection connection = DBUtil.getConnection()){
            String sql = "select id, student_name from student where classes_id=?";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1,id);

                try(ResultSet resultSet = statement.executeQuery()){
                    while(resultSet.next()){
                        DictionaryTag tag = new DictionaryTag();
                        tag.setDictionaryTagKey(String.valueOf(resultSet.getInt("id")));
                        tag.setDictionaryTagValue(resultSet.getString("student_name"));
                        tags.add(tag);
                    };
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("查询学生数据字典出错", e);
        }

        return tags;
    }
}
