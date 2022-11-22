package com.wangzhen.web.servlet.login; /**
 * @author wangzhen
 * @creat ${YEAR-}${MONTH-}$DAY-16:14
 */

import com.alibaba.fastjson.JSON;
import com.wangzhen.service.User.UserService;
import com.wangzhen.service.User.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addLikesServlet")
public class AddLikesServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 接受页面ajax发送的data的id
        BufferedReader bf = request.getReader();
        String parms = bf.readLine();
        // 2. 将json的id转为int的id
        Integer id = JSON.parseObject(parms, int.class);
        // 3. 调用方法完成添加
        userService.addLikes(id);
        // 4. 响应数据
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
