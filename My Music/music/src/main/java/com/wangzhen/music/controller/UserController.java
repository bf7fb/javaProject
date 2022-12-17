package com.wangzhen.music.controller;

import com.wangzhen.music.pojo.User;
import com.wangzhen.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author wz
 * @ClassName UserController
 * @date 2022/12/6 15:17
 * @Description TODO
 */
@Controller
public class UserController {
    @Autowired
    private UserService userServiceImpl;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session){
        boolean result = userServiceImpl.login(user);
        if(result == false){
            // 登录失败 跳转登录页面
            model.addAttribute("loginMessage","账号或密码错误~请重试");
            return "login";
        }
        // 登录成功 跳转音乐页面
        user = userServiceImpl.selectByUserName(user.getUsername());
        System.out.println(user);

        session.setAttribute("user",user);
        return "search";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(User user, Model model){
        boolean result = userServiceImpl.register(user);
        if (result == true){
            // 注册成功跳转登录页面
            model.addAttribute("registerMessage","恭喜您,注册成功");
            return "login";
        }
        // 注册失败 跳转注册页面 显示错误信息
        model.addAttribute("registerMessage","账号已存在~请重试");
        return "register";
    }

    @RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
    public String adminLogin(User user, Model model){
        boolean result = userServiceImpl.adminLogIn(user);
        if(result == false){
            // 登录失败 跳转登录页面
            model.addAttribute("adminLoginMessage","账号或密码错误~请重试");
            return "adminLogin";
        }
        // 登录成功 跳转管理员页面

        return "redirect:/selectAllMusicAdmin";
    }


}
