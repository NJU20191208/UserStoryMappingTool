package cn.edu.nju.userstorymappingtool.dao;

import cn.edu.nju.userstorymappingtool.entity.Mapcode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MapcodeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mapcode
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mapcode
     *
     * @mbg.generated
     */
    int insert(Mapcode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mapcode
     *
     * @mbg.generated
     */
    Mapcode selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mapcode
     *
     * @mbg.generated
     */
    List<Mapcode> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mapcode
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Mapcode record);

    Mapcode selectumid(Mapcode mapcode);

    int updateByumId(Mapcode mapcode);
}