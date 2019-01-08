package cn.edu.nju.userstorymappingtool.service.intf;

import cn.edu.nju.userstorymappingtool.entity.Subtask;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/9 21:43
 * @Version 1.0
 */
@Repository
public interface SubTaskService {
//    public Subtask findSubBySubId(int id);

    public int insertSubTask(int algNum,int dividedId,String itemName1,String itemDes1,String itemName2,String itemDes2);

    public int updateRandom(int algNum,int random,int subtaskid);

    public  int[] getNumber(int total);

    public List<Subtask> selectAllSubTask(int algNum);
    public void geneSubTask(int releaseId);
    public void updateFre(int algNum,Subtask subtask);

}
