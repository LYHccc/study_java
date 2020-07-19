package lyh.servlet;

import lyh.dao.ExamRecordDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/examRecord/delete")
public class ExamRecordDeleteServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String[] arr = req.getParameterValues("ids");
        int num = ExamRecordDAO.delete(arr);
        return null;
    }
}
