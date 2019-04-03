package cn.edu.nju.userstorymappingtool.service.intf;

import cn.edu.nju.userstorymappingtool.entity.Mapcode;
import cn.edu.nju.userstorymappingtool.entity.Storymap;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IStoryMapService {

    List<Storymap> getAllMapsByUserid(Long userid);

    long addStoryMap(Storymap storymap);

    long deleteStoryMap(Long mapid);

    List<Storymap> getAllMapsByKeyword(Storymap storymap);

//    新加
    int saveStoryMap(Mapcode mapcode);

    String findStoryMap(long userid,long mapid);

    int updateStoryMap(Mapcode mapcode);


}
