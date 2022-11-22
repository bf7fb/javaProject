package com.wangzhen.web.servlet.login;

import com.wangzhen.pojo.User;
import com.wangzhen.service.User.UserService;
import com.wangzhen.service.User.UserServiceImpl;
import com.wangzhen.util.StrtingUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
        UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户 注册的用户名与密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //  去除用户输入的首位空格
        username = StrtingUtil.myTrim(username);
        password = StrtingUtil.myTrim(password);

        User user = new User(username, password);

        // 获取机器产生的验证码及 用户的验证码
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");
        String checkCode = request.getParameter("checkCode");

        //判断
        if(!checkCodeGen.equalsIgnoreCase(checkCode)){
            // 验证码错误
            request.setAttribute("register_msg","验证码错误 请重试~");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }

        // 调用service 添加
        boolean flag = userService.register(user);
        // 根据注册是否成功 跳转不同页面
        if (flag){
            // 注册成功
            request.setAttribute("register_msg","注册成功 请登录~");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            // 注册失败
            request.setAttribute("register_msg","注册失败 请重试~");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
