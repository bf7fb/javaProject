package com.wangzhen.school.controller;

import com.wangzhen.school.pojo.Dorm;
import com.wangzhen.school.service.dorm.DormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author wz
 * @ClassName DormController
 * @date 2022/11/3 18:32
 * @Description TODO
 */
@Controller
public class DormController {
    @Autowired
    private DormService dormServiceImpl;

    @RequestMapping(value = "/dorm", method = RequestMethod.GET)
    public String selectAll(Model model){
        List<Dorm> dorms = dormServiceImpl.selectAll();
        model.addAttribute("dorms",dorms);
        return "dormList";
    }

    @RequestMapping(value = "/dorm", method = RequestMethod.POST)
    public String addDorm(Model model,Dorm dorm){
        dormServiceImpl.addDorm(dorm);
        model.addAttribute("add_message","添加成功~");
        return "redirect:/dorm";
    }
    @RequestMapping(value = "/deleteDorm/{dormId}")
    public String deleteDorm(@PathVariable("dormId") Integer dormId){
        dormServiceImpl.deleteDorm(dormId);

        return "redirect:/dorm";
    }

    /**
     * 回显要修改的数据
     * @param dormId
     * @param model
     * @return
     */
    @RequestMapping(value = "/dorm/{dormId}", method = RequestMethod.GET)
    public String reviewDorm(@PathVariable("dormId") Integer dormId, Model model){
        Dorm dorm = dormServiceImpl.selectById(dormId);
        model.addAttribute("dorm",dorm);
        return "dormUpdate";
    }
    /**
     * 对数据进行修改
     */
    @RequestMapping(value = "/dorm", method = RequestMethod.PUT)
    public String updateDorm(Dorm dorm){
        dormServiceImpl.updateDom(dorm);
        System.out.println(dorm);
        return "redirect:/dorm";
    }
    /**
     * 条件查询
     */
    @RequestMapping(value = "/dorm/selectByCondition", method = RequestMethod.POST)
    public String selectByCondition(Dorm dorm, Model model){
        if(dorm.getDormName() == null || dorm.getDormName() == ""){
//            如果查询为空 则跳转查询所有页面  此处也可以在mapper.xml中处理
            return "redirect:/dorm";
        }
        List<Dorm> dorms = dormServiceImpl.selectByCondition(dorm);
        model.addAttribute("dorms",dorms);
        return "dormList";
    }
}
