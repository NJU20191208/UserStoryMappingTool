package cn.edu.nju.userstorymappingtool.service.impl;

import cn.edu.nju.userstorymappingtool.dao.StorymapMapper;
import cn.edu.nju.userstorymappingtool.entity.Storymap;
import cn.edu.nju.userstorymappingtool.service.intf.IStoryMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryMapServiceImpl implements IStoryMapService {

    @Autowired
    StorymapMapper storymapMapper;

    @Override
    public List<Storymap> getAllMapsByUserid(Long userid) {
        return storymapMapper.selectAllMapsByUserid(userid);
    }

    @Override
    public long addStoryMap(Storymap storymap) {
        return storymapMapper.insert(storymap);
    }
}
