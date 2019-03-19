package cn.edu.nju.userstorymappingtool.dao;

import cn.edu.nju.userstorymappingtool.entity.MapCode;
import cn.edu.nju.userstorymappingtool.entity.Storymap;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface StorymapMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storymap
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long mapid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storymap
     *
     * @mbg.generated
     */
    int insert(Storymap record);
    
    int saveStoryMap(MapCode mapcode);
    
    String findStoryMap(long userid,long mapid);
    
    int updateStoryMap(MapCode mapcode);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storymap
     *
     * @mbg.generated
     */
    Storymap selectByPrimaryKey(Long mapid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storymap
     *
     * @mbg.generated
     */
    List<Storymap> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storymap
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Storymap record);
    

    List<Storymap> selectAllMapsByUserid(Long userid);
}