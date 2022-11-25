package com.wangzhen.school.service.student;

import com.wangzhen.school.mapper.StudentMapper;
import com.wangzhen.school.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wz
 * @ClassName StuServiceImpl
 * @date 2022/11/3 17:53
 * @Description TODO
 */
@Service
@Transactional
public class StuServiceImpl implements StuService{
    @Autowired
    private StudentMapper studentMapper;
    public List<Student> selectAll(Integer dormId) {
        List<Student> students = studentMapper.selectAll(dormId);
        return students;
    }

    public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }

    public void deleteStudent(Integer stuId) {
        studentMapper.deleteStudent(stuId);
    }

    public Student selectById(Integer stuId) {
        Student student = studentMapper.selectById(stuId);
        return student;
    }

    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    public List<Student> selectByCondition(String message) {
        String newMessage = "%" + message + "%";
        List<Student> students = studentMapper.selectByCondition(newMessage);
        return students;
    }
}
