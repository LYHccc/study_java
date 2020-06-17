package lyh.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if(session != null){
            //权限校验
            //TODO:if(权限校验)
            return true;
            //else
            //response.setStatus(HttpStatus.FORBIDDEN.value());//403
        }
        //未被授权
        response.setStatus(HttpStatus.UNAUTHORIZED.value());//401
        System.out.println(request.getScheme());//协议：http
        System.out.println(request.getContextPath());//项目部署路径
        System.out.println(request.getServerName());//服务器ip或域名
        System.out.println(request.getServerPort());//服务器端口号
        response.sendRedirect("/login.html");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
