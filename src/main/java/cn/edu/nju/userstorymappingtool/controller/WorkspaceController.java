package cn.edu.nju.userstorymappingtool.controller;

import cn.edu.nju.userstorymappingtool.entity.Storymap;
import cn.edu.nju.userstorymappingtool.entity.User;
import cn.edu.nju.userstorymappingtool.service.intf.IStoryMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WorkspaceController {

    @Autowired
    IStoryMapService storymapService;

    @RequestMapping(value = "/workspace")
    public String workspace(HttpServletRequest request, HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("currentUser");
        if(user != null) {
            List<Storymap> storymaps = storymapService.getAllMapsByUserid(user.getUserid());
            model.addAttribute("storymaps", storymaps);
            return "workspace";
        }else{
            return "login";
        }
    }
}
