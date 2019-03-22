package cn.edu.nju.userstorymappingtool.controller;

import cn.edu.nju.userstorymappingtool.entity.Storymap;
import cn.edu.nju.userstorymappingtool.entity.User;
import cn.edu.nju.userstorymappingtool.service.intf.IStoryMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StoryMapController {

    @Autowired
    IStoryMapService storyMapService;

    @PostMapping("add_map")
    @ResponseBody
    public String addMap(HttpServletRequest request, HttpSession httpSession, String name, String description, Model model) {
        User user = (User) httpSession.getAttribute("currentUser");
        if (user != null) {
            Storymap storymap = new Storymap();
            storymap.setName(name);
            storymap.setDescription(description);
            storymap.setUserid(user.getUserid());
            Long mapid = storyMapService.addStoryMap(storymap);
            return mapid.toString();
        } else {
            return "login";
        }
    }

    @PostMapping("delete_map")
    @ResponseBody
    public String deleteMap(HttpServletRequest request, HttpSession httpSession, Long mapid, Model model) {
        User user = (User) httpSession.getAttribute("currentUser");
        if (user != null) {
            Long deletedMapid = storyMapService.deleteStoryMap(mapid);
            return deletedMapid.toString();
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/newstorymap")
    public String newStoryMap(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("currentUser");
        if(user != null) {
            return "newstorymap";
        }else{
            return "login";
        }
    }

    @RequestMapping(value = "/drawmap")
    public String drawMap(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("currentUser");
        if(user != null) {
            return "drawmap";
        }else{
            return "login";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/search_map")
    public Object workspace(HttpServletRequest request, HttpSession httpSession, String keyword, Model model) {
        User user = (User) httpSession.getAttribute("currentUser");
        if(user != null) {
            Storymap storymap = new Storymap();
            storymap.setUserid(user.getUserid());
            storymap.setName(keyword);
            List<Storymap> storymaps = storyMapService.getAllMapsByKeyword(storymap);
            if(storymaps == null || storymaps.isEmpty()){
                storymaps = new ArrayList<Storymap>();
            }
            return storymaps;
        }else{
            return "login";
        }
    }
}
