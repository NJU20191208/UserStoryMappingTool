package cn.edu.nju.userstorymappingtool.service.intf;

import cn.edu.nju.userstorymappingtool.entity.Storymap;

import java.util.List;

public interface IStoryMapService {

    List<Storymap> getAllMapsByUserid(Long userid);

    long addStoryMap(Storymap storymap);

    long deleteStoryMap(Long mapid);

    List<Storymap> getAllMapsByKeyword(Storymap storymap);
}
