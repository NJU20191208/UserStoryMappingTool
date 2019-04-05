package cn.edu.nju.userstorymappingtool.controller;

import cn.edu.nju.userstorymappingtool.entity.Mapcode;
import cn.edu.nju.userstorymappingtool.entity.Storymap;
import cn.edu.nju.userstorymappingtool.entity.User;
import cn.edu.nju.userstorymappingtool.service.intf.IStoryMapService;
import cn.edu.nju.userstorymappingtool.service.intf.IUserService;
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
    @Autowired
    IUserService userService;

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



    @PostMapping("save_map")
    @ResponseBody
    public long saveMap(HttpServletRequest request, HttpSession httpSession,long mapid,String code){
        User user = (User) httpSession.getAttribute("currentUser");
        System.out.println(code);
        Mapcode mapcode = new Mapcode();
        mapcode.setUserid(user.getUserid());
        mapcode.setMapid(mapid);
        mapcode.setCode(code);
        int rs = -1;
        String CodeSaved = storyMapService.findStoryMap(user.getUserid(), mapid);
        if(user != null){
            if(CodeSaved != null && !"".equals(CodeSaved)){
                rs = storyMapService.updateStoryMap(mapcode);
            }else{
                rs = storyMapService.saveStoryMap(mapcode);
            }
        }
        System.out.println(rs);
        return rs;
    }

    @PostMapping("find_map")
    @ResponseBody
    public String findMap(HttpServletRequest request, HttpSession httpSession,long mapid){
        User user = (User) httpSession.getAttribute("currentUser");
        System.out.println("user.getUsername():"+user.getUsername());
        User currentUser = userService.findUserByUserName(user.getUsername());
        String code = "";
        if(user != null){
            System.out.println("currentUser.getUserid()"+currentUser.getUserid());
            code = storyMapService.findStoryMap(currentUser.getUserid(), mapid);
        }
        return code;
    }


}
