package lyh.fillter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        /**
         * 判断是否是敏感资源
         * 如果是，获取session
         * 获取不到的话，那么重定向到登录页面
         */
        String uri = req.getServletPath();
        if(!uri.startsWith("/public/") && !uri.startsWith("/static/") && !uri.equals("/user/login")){
            //获取session
            HttpSession session = req.getSession(false);
            //没有登录
            if(session == null){
                //resp.sendRedirect("/ses/public/index.html");
                String scheme = req.getScheme();//http
                String host = req.getServerName();//服务器ip
                int port = req.getServerPort();//服务器端口
                String contextPath = req.getContextPath();//项目部署名
                String baseUrl = scheme + "://" + host + ":" + port + contextPath;
                resp.sendRedirect(baseUrl + "/public/index.html");
                return;
            }
        }
        //非敏感资源或者敏感资源登录之后，继续调用后边的过滤器
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
