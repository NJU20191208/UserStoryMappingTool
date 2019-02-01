package cn.edu.nju.userstorymappingtool.controller;

import cn.edu.nju.userstorymappingtool.entity.Storymap;
import cn.edu.nju.userstorymappingtool.entity.User;
import cn.edu.nju.userstorymappingtool.service.intf.IStoryMapService;

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
            Long mapid = storyMapService.addStoryMap(storymap);
            model.addAttribute("status", "OK");
            model.addAttribute("mapid", mapid);
            return "OK";
        } else {
            return "login";
        }
    }
}
