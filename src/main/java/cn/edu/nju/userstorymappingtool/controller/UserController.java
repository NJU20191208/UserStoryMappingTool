package cn.edu.nju.userstorymappingtool.controller;

import cn.edu.nju.userstorymappingtool.entity.User;
import cn.edu.nju.userstorymappingtool.service.intf.IUserService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


//证明是controller层并返回json
@Controller
public class UserController {
    //依赖注入
    @Autowired
    IUserService userService;


    @PostMapping("login")
    @ResponseBody
    public String login(HttpServletRequest request, String username, String password) {
        User user = userService.findUserByUserName(username);
        if (user != null && user.getPassword() != null && user.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", user);
            return "OK";
        } else {
            return "用户名或密码错误";
        }

    }


    @PostMapping("add_user")
    @ResponseBody
    public String addUser(HttpServletRequest request, String username, String password) {
        User user = userService.findUserByUserName(username);
        if (user != null) {
            return "该用户已注册";
        } else {
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
            int userID = userService.addUser(user);
            if (userID > 0) {
                return "OK";
            } else {
                return "注册用户失败";
            }
        }

    }

    @RequestMapping(value = "")
    public String home(HttpServletRequest request, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("currentUser");
        if(user != null) {
            request.setAttribute("userInfo", user);
            return "forward:workspace";
        }else{
            return "home";
        }
    }

    @RequestMapping(value = "/signup")
    public String signUp(HttpSession httpSession) {
        return "signup";
    }

    @RequestMapping(value = "/login")
    public String login(HttpSession httpSession) {
        return "login";
    }


}
