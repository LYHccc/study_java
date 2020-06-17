package lyh.controller;

import lyh.model.User;
import lyh.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/1")
public class LoginController {
    //@Autowired
    @Resource
    private LoginService loginService;

    @Autowired
    @Qualifier("user1")
    private User user1;

    @Resource(name="user2")
    private User user2;

    @RequestMapping("/login")
    public String login(Integer i){
        System.out.println(loginService);
        System.out.println(user1);
        System.out.println(user2);
        if(i == 1){
            return "redirect:/index.html";
        }else{
            return "forward:/index.html";
        }
    }

    @RequestMapping(value = "/login2", method = RequestMethod.POST)
    @ResponseBody
    //@RequestParam可以加，可以不加
    public Object login2(@RequestParam("username") String username, String password){
        System.out.println(username + " = " + password);
        User user = new User();
        user.setUsername("烤鸭");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping(value = "/login3", method = RequestMethod.POST)
    @ResponseBody
    public Object login3(User u){
        System.out.println(u);
        User user = new User();
        user.setUsername("烤鸭");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping(value = "/login4", method = RequestMethod.POST)
    @ResponseBody
    public Object login4(@RequestBody User u){
        System.out.println(u);
        User user = new User();
        user.setUsername("烤鸭");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping(value = "/login5", method = RequestMethod.POST)
    @ResponseBody
    public Object login5(HttpServletRequest request, HttpServletResponse response, User u){
        if("dio".equals(u.getUsername()) && "123".equals(u.getPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
            User user = new User();
            user.setUsername("烤鸭");
            user.setPassword("123");
            user.setBirthday(new Date());
            return user;
        }
        throw new RuntimeException("登录不成功");
    }

    @RequestMapping(value = "/{type}/login6", method = RequestMethod.POST)
    @ResponseBody
    public Object login6(@PathVariable("type") String type){
        System.out.println(type);
        User user = new User();
        user.setUsername("烤鸭");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }
}
