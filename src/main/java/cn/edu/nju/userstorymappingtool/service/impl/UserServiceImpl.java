package cn.edu.nju.userstorymappingtool.service.impl;


import cn.edu.nju.userstorymappingtool.dao.UserMapper;
import cn.edu.nju.userstorymappingtool.entity.User;
import cn.edu.nju.userstorymappingtool.service.intf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }

    @Override
    public Long deleteUser(Long userid) {
        return userMapper.deleteByPrimaryKey(userid);
    }

    @Override
    public int updateUserPassword(User user) {
        return userMapper.updatePw(user);
    }

    @Override
    public User findUserByUserName(String username) {
        User user = userMapper.findUserByUserName(username);
        return user;
    }

}
