package cn.edu.nju.userstorymappingtool.service.impl;

import cn.edu.nju.userstorymappingtool.dao.MapcodeMapper;
import cn.edu.nju.userstorymappingtool.dao.StorymapMapper;
import cn.edu.nju.userstorymappingtool.entity.Mapcode;
import cn.edu.nju.userstorymappingtool.entity.Storymap;
import cn.edu.nju.userstorymappingtool.service.intf.IStoryMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryMapServiceImpl implements IStoryMapService {

    @Autowired
    StorymapMapper storymapMapper;
    @Autowired
    MapcodeMapper mapcodeMapper;

    @Override
    public List<Storymap> getAllMapsByUserid(Long userid) {
        return storymapMapper.selectAllMapsByUserid(userid);
    }

    @Override
    public long addStoryMap(Storymap storymap) {
        return storymapMapper.insert(storymap);
    }

    @Override
    public long deleteStoryMap(Long mapid) {
        return storymapMapper.deleteByPrimaryKey(mapid);
    }

    @Override
    public List<Storymap> getAllMapsByKeyword(Storymap storymap) {
        return storymapMapper.selectAllMapsByKeyword(storymap);
    }

    @Override
    public int saveStoryMap(Mapcode mapcode) {
        return mapcodeMapper.insert(mapcode);
    }

    @Override
    public String findStoryMap(long userid, long  mapid) {
        Mapcode mapcode = new Mapcode();
        mapcode.setUserid(userid);
        mapcode.setMapid(mapid);
        System.out.println(userid+"="+mapid);
        try{
            mapcode = mapcodeMapper.selectumid(mapcode);
            System.out.println(mapcode.getId());
        }catch(Exception e){
            System.out.println("未找到地图");
        }
        if(mapcode == null){
            return "";
        }else {
            return mapcode.getCode();
        }
    }

    @Override
    public int updateStoryMap(Mapcode mapcode) {
        return mapcodeMapper.updateByumId(mapcode);
    }


}
