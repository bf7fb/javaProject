package com.wangzhen.school.mapper;

import com.wangzhen.school.pojo.Dorm;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author wz
 * @ClassName DormMapper
 * @date 2022/11/3 17:58
 * @Description 宿舍mapper
 */
public interface DormMapper {
    @Select("select * from dorm")
    List<Dorm> selectAll();

    /**
     * 修改数据前 要回显数据 获取回显数据的id  然后查询要回显的数据
     * @param dormId
     * @return
     */
    @Select("select * from dorm where dorm_id = #{dormId}")
    Dorm selectById(Integer dormId);

    @Insert("insert into dorm(dorm_Name) values(#{dormName})")
    void addDorm(Dorm dorm);

    @Delete("delete from dorm where dorm_id = #{dormId}")
    void deleteDorm(Integer dormId);

    @Update("update dorm set dorm_name = #{dormName} where dorm_id = #{dormId}")
    void updateDorm(Dorm dorm);

    @Select("select * from dorm where dorm_name like #{dormName}")
//    不携带
    List<Dorm> selecyByCondition(Dorm dorm);

//    携带mapper.xml查询
//    List<Dorm> selecyByCondition(@Param("dorm") Dorm dorm);

}
