package com.wangzhen.school.service.student;

import com.wangzhen.school.pojo.Student;

import java.util.List;

/**
 * @author wz
 * @ClassName StuService
 * @date 2022/11/3 17:52
 * @Description TODO
 */
public interface StuService {
    /**
     * 查询某个宿舍所有成员
     * @param dormId
     * @return
     */
    List<Student> selectAll(Integer dormId);

    /**
     * 为这个宿舍添加学生
     */
    void addStudent(Student student);

    /**
     *  删除宿舍的某个成员
     */
    void deleteStudent(Integer stuId);

    /**
     * 修改数据前进行回显
     */
    Student selectById(Integer stuId);

    /**
     * 实现修改
     */
    void updateStudent(Student student);

    /**
     * 条件查询
     */
    List<Student> selectByCondition(String message);

}
