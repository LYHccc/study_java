package lyh.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

//Controller中所有处理客户端请求的方法，抛异常都会进入异常处理逻辑
@ControllerAdvice
public class ExceptionAdvisor {
    /*
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handle(Exception e){//Controller方法中抛的异常，会注入到异常参数中
        Map<String, String> map = new HashMap<>();
        map.put("error", e.getMessage());
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        map.put("stackTrace", stringWriter.toString());
        return map;
    }
    */

    @ExceptionHandler(Exception.class)
    public String handle(HttpServletResponse response) throws IOException {//Controller方法中抛的异常，会注入到异常参数中
        response.sendRedirect("/error.html");
        return null;
    }
}
