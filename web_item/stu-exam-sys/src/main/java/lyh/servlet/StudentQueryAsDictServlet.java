package lyh.servlet;

import lyh.dao.StudentDAO;
import lyh.model.DictionaryTag;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/student/queryAsDict")
public class StudentQueryAsDictServlet extends AbstractBaseServlet{

    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取班级id
        String key = req.getParameter("dictionaryKey");
        int id = Integer.parseInt(key);
        List<DictionaryTag> list = StudentDAO.queryAsDict(id);
        return list;
    }
}
