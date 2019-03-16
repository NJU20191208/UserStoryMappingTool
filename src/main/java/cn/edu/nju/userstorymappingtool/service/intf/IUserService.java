package cn.edu.nju.userstorymappingtool.service.intf;

import cn.edu.nju.userstorymappingtool.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: yzs
 * @Date: 2019/01/13
 * @Version 1.0
 */
public interface IUserService {

    User findUserByUserName(String username);

    int addUser(User user);
}
