package cn.edu.nju.userstorymappingtool.service.intf;

import cn.edu.nju.userstorymappingtool.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: yzs
 * @Date: 2019/01/13
 * @Version 1.0
 */
@Repository
public interface IUserService {

    public User findUserByUserName(String username);

    public int addUser(User user);
}
