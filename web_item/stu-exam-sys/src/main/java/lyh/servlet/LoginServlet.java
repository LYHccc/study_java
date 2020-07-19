package lyh.servlet;

import lyh.dao.UserDAO;
import lyh.model.User;
import lyh.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user/login")
public class LoginServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //解析HTTP请求的用户名密码
        User user = JSONUtil.read(req.getInputStream(), User.class);
        //根据用户名密码查询数据库中的用户
        User queryUser = UserDAO.query(user);
        //如果没有查询到
        if(queryUser == null){
            throw new RuntimeException("用户名密码校验失败");
        }
        //查询到设置session
        HttpSession session = req.getSession();
        session.setAttribute("user", queryUser);
        return null;
    }
}
