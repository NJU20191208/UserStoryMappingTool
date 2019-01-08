package cn.edu.nju.userstorymappingtool.service.intf;

import cn.edu.nju.userstorymappingtool.entity.OriginalData;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wx
 * @Date: 2018/12/17 16:07
 * @Version 1.0
 */
@Repository
public interface OriginalDataService {
    List selectAllItemsNames(int id);
    List selectAllItemDes(int id);
    List<OriginalData> selectAll();
}
