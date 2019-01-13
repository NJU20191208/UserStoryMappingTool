package cn.edu.nju.userstorymappingtool.service.impl;

import cn.edu.nju.userstorymappingtool.dao.ReleaseMapper;
import cn.edu.nju.userstorymappingtool.dao.SubtaskMapper;
import cn.edu.nju.userstorymappingtool.dao.UsertaskMapper;
import cn.edu.nju.userstorymappingtool.entity.Release;
import cn.edu.nju.userstorymappingtool.service.intf.ReleaseService;
import cn.edu.nju.userstorymappingtool.service.intf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.String;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/7 18:30
 * @Version 1.0
 */
@Service
public class ReleaseServiceImpl implements ReleaseService {

    @Autowired
    ReleaseMapper releaseMapper;

    @Autowired
    UsertaskMapper usertaskMapper;
    @Autowired
    SubtaskMapper subtaskMapper;
    @Autowired
    IUserService userService;


//    @Override
//    public List finAlgsByInputName(String inputName) {
//
//        List algs = releaseDao.finAlgsByInputName(inputName);
//        return algs;
//    }
//
//    @Override
//    public void updateDivided(String divided,String inputName,String algName) {
//        releaseDao.updateDivided(divided,inputName,algName);
//    }
//
//    @Override
//    public String findDivided(String inputName, String algName) {
//        String divided = releaseDao.findDivided(inputName,algName);
//        return divided;
//    }

    @Override
    public void updateIfDivided(int releaseid, String ifDivided) {
        releaseMapper.updateIfDivided(releaseid,ifDivided);
    }

    @Override
    public int insertRelease(String plan) {
        List<String> plans = releaseMapper.selectPlans();
        //TODO
        //判断的很粗糙，需要改，可以结合发布者ID等因素来判断
        if (plans.contains(plan))
        {
            return -1;
        }
        else {
            Release release = new Release();
            release.setPlan(plan);
            releaseMapper.insertRelease(release);
            int id = release.getReleaseid();
            return id;
        }
    }

    @Override
    public String findDivided(int id) {
        String ifDivided = releaseMapper.findDivided(id);
        return ifDivided;
    }


}
