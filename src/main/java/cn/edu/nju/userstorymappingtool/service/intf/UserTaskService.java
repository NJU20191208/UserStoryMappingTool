package cn.edu.nju.userstorymappingtool.service.intf;


import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/11 14:16
 * @Version 1.0
 */
@Repository
public interface UserTaskService {
    public void assignTaskToU(int userId,int taskId);

    public List findByUserId(int userId);

}
