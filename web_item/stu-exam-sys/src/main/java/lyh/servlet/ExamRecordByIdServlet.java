package lyh.servlet;

import lyh.dao.ExamRecordDAO;
import lyh.model.ExamRecord;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/examRecord/queryById")
public class ExamRecordByIdServlet extends AbstractBaseServlet{

    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String i = req.getParameter("id");
        int id = Integer.parseInt(i);
        ExamRecord record = ExamRecordDAO.queryById(id);
        return record;
    }
}
