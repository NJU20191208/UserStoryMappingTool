package cn.edu.nju.userstorymappingtool.service.impl;


import cn.edu.nju.userstorymappingtool.dao.UsertaskMapper;
import cn.edu.nju.userstorymappingtool.service.intf.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/11 14:17
 * @Version 1.0
 */
@Service
public class UserTaskServiceImpl implements UserTaskService {
    @Autowired
    UsertaskMapper usertaskMapper;

    @Override
    public void assignTaskToU(int userId, int taskId) {
    usertaskMapper.assignTaskToU(userId,taskId);
    }

    @Override
    public List findByUserId(int userId) {
        List list = usertaskMapper.findByUserId(userId);
        return null;
    }
    
}
