package cn.edu.nju.userstorymappingtool.service.intf;

import cn.edu.nju.userstorymappingtool.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/4 19:02
 * @Version 1.0
 */
@Repository
public interface UserService {
//    public User userLogin(String username,String password);

    public User findUserByUserName(String username);

 //   public void  assignTaskToU(int userId,int taskId);

    public  List<Integer> selectAllId();

    public void updateTasking(int userid);
}
