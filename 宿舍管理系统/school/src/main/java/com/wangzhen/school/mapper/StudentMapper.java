package com.wangzhen.school.mapper;

import com.wangzhen.school.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author wz
 * @ClassName StudentMapper
 * @date 2022/11/3 17:56
 * @Description Dao 处理学生
 */
public interface StudentMapper {
    /**
     * 查询某个宿舍
     */
    @Select("select distinct stu_id,stu_name,stu_sex,stu_age" +
            ",stu_class,stu_num, stu_photo, stu_dorm_id from dorm t1 join student t2 " +
            "on #{dormId} = t2.stu_dorm_id order by stu_id")
    List<Student> selectAll(Integer dormId);

    /**
     * 为宿舍添加成员
     */
    @Insert("insert into student(stu_name,stu_sex,stu_age,stu_class,stu_num,stu_photo,stu_dorm_id)" +
            "values (#{stuName},#{stuSex},#{stuAge},#{stuClass},#{stuNum},#{stuPhoto},#{stuDormId})")
    void addStudent(Student student);

    /**
     *  删除某个学生
     */
    @Delete("delete from student where stu_id = #{stuId}")
    void deleteStudent(Integer stuId);

    /**
     * 查询要回显的宿舍成员数据
     */
    @Select("select * from student where stu_id = #{stuId}")
    Student selectById(Integer stuId);

    /**
     * 实现修改
     */
    @Update("update student set stu_name = #{stuName}, stu_sex = #{stuSex}, stu_age = #{stuAge}," +
            "stu_class = #{stuClass},stu_num = #{stuNum},stu_photo = #{stuPhoto}, " +
            "stu_dorm_id = #{stuDormId} where stu_id = #{stuId}")
    void updateStudent(Student student);

    /**
     *  学生查询功能
     */
    @Select("select * from student where stu_name like #{message} or stu_sex like #{message}" +
            "or stu_age like #{message} or stu_class like #{message} or stu_num like #{message}")
    List<Student> selectByCondition(String message);
}
