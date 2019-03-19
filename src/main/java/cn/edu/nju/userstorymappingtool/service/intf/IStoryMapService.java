package cn.edu.nju.userstorymappingtool.service.intf;

import cn.edu.nju.userstorymappingtool.entity.MapCode;
import cn.edu.nju.userstorymappingtool.entity.Storymap;

import java.util.List;

public interface IStoryMapService {

    List<Storymap> getAllMapsByUserid(Long userid);

    long addStoryMap(Storymap storymap);
    
    long saveStoryMap(MapCode mapcode);
    
    String findStoryMap(long userid,long mapid);

	long updateStoryMap(MapCode mapcode);

}
