package cn.edu.nju.userstorymappingtool.controller;

import cn.edu.nju.userstorymappingtool.entity.MapCode;
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
    
    @PostMapping("save_map")
    @ResponseBody
    public long saveMap(HttpServletRequest request, HttpSession httpSession){
    	User user = (User) httpSession.getAttribute("currentUser");
    	long mapid = (long)request.getAttribute("mapid");
    	String code = (String)request.getAttribute("code");
    	if(user != null){
    		if(storyMapService.findStoryMap(user.getUserid(), mapid) != null){
    			return storyMapService.updateStoryMap(new MapCode(user.getUserid(),mapid,code));
    		}else{
    			return storyMapService.saveStoryMap(new MapCode(user.getUserid(),mapid,code));
    		}
    	}
    	return 0;
    }
    
    @PostMapping("find_map")
    @ResponseBody
    public String findMap(HttpServletRequest request, HttpSession httpSession){
    	User user = (User) httpSession.getAttribute("currentUser");
    	long mapid = (long)request.getAttribute("mapid");
    	if(user != null){
    		return storyMapService.findStoryMap(user.getUserid(), mapid);
    	}
    	return null;
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
}
