package cn.edu.nju.userstorymappingtool.service.intf;


import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/7 18:29
 * @Version 1.0
 */
@Repository
public interface ReleaseService {

//    public List finAlgsByInputName(String inputName);
//
//    public void updateDivided(String divided,String inputName,String algName);
//
//    public String findDivided(String inputName,String algName);
    int insertRelease(String plan);

    String findDivided(int id);

    public void updateIfDivided(int releaseid,String ifDivided);

  //  public void assignTaskToUser();


}
