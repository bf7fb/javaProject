package com.wangzhen.school.controller;

import com.wangzhen.school.pojo.Dorm;
import com.wangzhen.school.pojo.Student;
import com.wangzhen.school.service.dorm.DormService;
import com.wangzhen.school.service.student.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author wz
 * @ClassName StudentController
 * @date 2022/11/3 18:32
 * @Description TODO
 */
@Controller
public class StudentController {
    @Autowired
    private StuService stuServiceImpl;

    @Autowired
    private DormService dormServiceImpl;
    /**
     * 查询所有学生
     * @param dormId
     * @param model
     * @return
     */
    @RequestMapping(value = "/student/{dormId}",method = RequestMethod.GET)
    public String selectAll(@PathVariable("dormId") Integer dormId , Model model){
        // stuDormId宿舍号 查询某个宿舍的所有成员
        List<Student> students = stuServiceImpl.selectAll(dormId);

        // dorms 存放每个学生查询出来的宿舍
        ArrayList<Dorm> dorms = new ArrayList<Dorm>();
        for (Student student : students) {
            Integer stuDormId = student.getStuDormId();
            Dorm dorm = dormServiceImpl.selectById(stuDormId);
            dorms.add(dorm);
        }

        model.addAttribute("dorms",dorms);

        model.addAttribute("students",students);
        return "stuList";
    }

    /**
     * 预处理 获取点击添加宿舍的dormId  携带着该Id跳转到添加页面
     * @param dormId
     * @return
     */
    @RequestMapping(value = "/to/addstu/{dormId}", method = RequestMethod.GET)
    public String toAddStudent(@PathVariable("dormId") Integer dormId){
        // 获取当前宿舍号 跳转到添加页面 然后在添加页面就可以获取宿舍号了
//        return "redirect:/student/" + dormId;
        return "addStu";
    }

    /**
     * 实现添加
     * @param dormId
     * @param student
     * @param photo
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/student/{dormId}", method = RequestMethod.POST)
    public String addStudent(@PathVariable("dormId") Integer dormId, Student student,
                             MultipartFile photo, HttpSession session) throws IOException {
        // 获取dormId  为student的stuDormId赋值
        Integer stuDormId = dormId;
        student.setStuDormId(stuDormId);
        // 测试查看
        System.out.println(student);

        //图片上传
        // 获取上传的文件名称
        String fileName = photo.getOriginalFilename();
        // 处理文件同名问题  .jpg
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + hzName;
        // 获取服务器中photo目录  默认在webapp下
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        File file = new File(photoPath);
        if(!file.exists()){
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + fileName;
        // 实现上传
        photo.transferTo(new File(finalPath));
        //  数据库存放图片uuid+后缀名
        student.setStuPhoto(fileName);
//        System.out.println(fileName);
        stuServiceImpl.addStudent(student);

        return "redirect:/student/" + dormId;
    }

    /**
     * 删除宿舍号dormID中stuId为XXX的学生
     * @param stuId
     * @return
     */
    @RequestMapping(value = "/deleteStu/{stuId}")
    public String deleteStudent(@PathVariable("stuId") Integer stuId){
        // 获取要删除的student对象
        Student student = stuServiceImpl.selectById(stuId);
        // 获取这个被删除学生所在的宿舍
        Integer stuDormId = student.getStuDormId();
        // 完成删除
        stuServiceImpl.deleteStudent(stuId);
        // 跳转到该宿舍
        return "redirect:/student/" + stuDormId;
    }

    /**
     *  修改学生数据前回显该数据
     */
    @RequestMapping(value = "/updateStudent/{stuId}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("stuId") Integer stuId,Model model){
        Student student = stuServiceImpl.selectById(stuId);
        model.addAttribute("updateStu",student);
        System.out.println(student);
        return "stuUpdate";
    }

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public String update(Student student,MultipartFile photo, HttpSession session,
                         Model model) throws IOException {
        System.out.println(student);
        // 获取dormId 修改过后重定向到当前宿舍
        Integer dormId = student.getStuDormId();

        // 查询学生要修改的宿舍 是否存在
        Dorm dorm = dormServiceImpl.selectById(dormId);

        // 如果宿舍不存在 则修改失败
        if(dorm == null){
            model.addAttribute("errDormMesage","错误！输入的寝室号不存在！");
            return "stuUpdate";
        }

        // 获取修改图片
        String fileName = photo.getOriginalFilename();

        if(fileName == null || fileName == ""){
            model.addAttribute("errFileMesage","错误！您还未选择图片！");
            return "stuUpdate";
        }
        // 处理文件同名问题  .jpg
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + hzName;
        // 获取服务器中photo目录  默认在webapp下
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        File file = new File(photoPath);
        if(!file.exists()){
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + fileName;
        // 实现上传
        photo.transferTo(new File(finalPath));

        // 设置stuPhoto的属性值 即图片名称＋后缀
        student.setStuPhoto(fileName);

        // 实现修改
        stuServiceImpl.updateStudent(student);
        return "redirect:/student/" + dormId;
    }

    /**
     * 查看具体某个学生信息
     * @param stuId
     * @param model
     * @return
     */
    @RequestMapping(value = "selectStudent/{stuId}", method = RequestMethod.GET)
    public String selectById(@PathVariable("stuId") Integer stuId,Model model){
        Student student = stuServiceImpl.selectById(stuId);
        model.addAttribute("selectStudent",student);
        return "stuSelect";
    }

    @RequestMapping(value = "/student/selectByCondition",method = RequestMethod.POST)
    public String selectByCondition(String message, Model model){
        //  如果查询为空则返回
        if(message == null || message == ""){
            return "redirect:/dorm";
        }
        List<Student> students = stuServiceImpl.selectByCondition(message);

        // dorms 存放每个学生查询出来的宿舍
        ArrayList<Dorm> dorms = new ArrayList<Dorm>();
        for (Student student : students) {
            Integer stuDormId = student.getStuDormId();
            Dorm dorm = dormServiceImpl.selectById(stuDormId);
            dorms.add(dorm);
        }

        model.addAttribute("dorms",dorms);

        model.addAttribute("students",students);

        return "stuList";
    }
}
