package lyh.dao;

import lyh.model.*;
import lyh.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamDAO {
    public static List<Exam> queryAsDict() {
        List<Exam> exams = new ArrayList<>();

        try (Connection connection = DBUtil.getConnection()){
            String sql = "select" +
                    "  e.id," +
                    "  e.exam_name," +
                    "  e.create_time," +
                    "  e.exam_desc," +
                    "  e.classes_id," +
                    "  e.course_id," +
                    "  c.classes_name," +
                    "  c2.course_name" +
                    " from exam e" +
                    "  join classes c on e.classes_id = c.id" +
                    "  join course c2 on e.course_id = c2.id";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                try(ResultSet resultSet = statement.executeQuery()){
                    while(resultSet.next()){
                        //设置考试对象
                        Exam exam = new Exam();
                        exam.setDictionaryTagKey(String.valueOf(resultSet.getInt("id")));
                        exam.setDictionaryTagValue(resultSet.getString("exam_name"));
                        exam.setExamDesc(resultSet.getString("exam_desc"));
                        exam.setCreateTime(new Date(resultSet.getTimestamp("create_time").getTime()));
                        
                        //设置班级对象
                        Classes classes = new Classes();
                        classes.setId(resultSet.getInt("classes_id"));
                        classes.setClassesName(resultSet.getString("classes_name"));
                        exam.setClasses(classes);

                        //设置课程对象
                        Course course = new Course();
                        course.setId(resultSet.getInt("course_id"));
                        course.setCourseName(resultSet.getString("course_name"));
                        exam.setCourse(course);

                        exams.add(exam);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("查询考试数据字典出错", e);
        }

        return exams;
    }
}
