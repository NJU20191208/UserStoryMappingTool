package cn.edu.nju.userstorymappingtool.service.intf;

import cn.edu.nju.userstorymappingtool.entity.Storymap;

import java.util.List;

public interface IStoryMapService {
    List<Storymap> getAllMaps(Long userid);
}
