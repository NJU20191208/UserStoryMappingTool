package cn.edu.nju.userstorymappingtool.controller;

import cn.edu.nju.userstorymappingtool.entity.User;
import cn.edu.nju.userstorymappingtool.service.intf.IUserService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


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

    @RequestMapping(value = "/manage")
    public String workspace(HttpServletRequest request, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("currentUser");
        if(user != null && "admin".equals(user.getUsername())) {
            return "main";
        }else{
            return "login";
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

    @RequestMapping(value = "/header")
    public String head(HttpSession httpSession) {
        return "header";
    }

    @RequestMapping(value = "/footer")
    public String footer(HttpSession httpSession) {
        return "footer";
    }

    @RequestMapping(value = "/left")
    public String left(HttpSession httpSession) {
        return "left";
    }

    @RequestMapping(value = "/manage_user")
    public String managerUser(HttpSession httpSession, Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "manageUser";
    }

    @RequestMapping(value = "/add_user")
    public String addUser(HttpSession httpSession) {
        return "addUser";
    }

    @RequestMapping(value = "/reset_password")
    public String resetPassword(HttpSession httpSession) {
        return "resetPassword";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("currentUser");
        return "login";

    }

}
