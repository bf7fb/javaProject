package com.wangzhen.web.servlet.login;

import com.wangzhen.pojo.User;
import com.wangzhen.service.User.UserService;
import com.wangzhen.service.User.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author wangzhen
 * @creat ${YEAR-}${MONTH-}$DAY-12:08
 */

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接受页面传递的账号和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        //2. 调用userService  检查账号密码
        User user = userService.select(username, password);

        //3. 判断查询对象是否为null
        if (user != null) {
            // 登陆成功跳转到查询所有页面  并且用session保存账号密码 勾选记住我 值为1
            if ("1".equals(remember)) {
                // 获取cookie
                Cookie c_username = new Cookie("username", username);
                Cookie c_password = new Cookie("password", password);
                // 设置存活时间
                c_username.setMaxAge(60 * 60 * 24 * 7);
                c_password.setMaxAge(60 * 60 * 24 * 7);
                // 转发cookie
                response.addCookie(c_username);
                response.addCookie(c_password);

            }

            // 一次对话 跳转页面 两次请求 session保存user
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/customerAnimal.html");
        } else {
            // 存储错误信息在request域中 显示登陆错误
            request.setAttribute("login_msg", "账号或密码错误~ 请重试");
            // 页面重新转发到登录页面 login.jsp
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
