package com.wangzhen.web.servlet.message;

import com.alibaba.fastjson.JSON;
import com.wangzhen.pojo.Animal;
import com.wangzhen.pojo.Message;
import com.wangzhen.service.Message.MessageService;
import com.wangzhen.service.Message.MessageServiceImpl;
import com.wangzhen.service.User.UserService;
import com.wangzhen.service.User.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangzhen
 * @creat 17:52
 */
@WebServlet("/message/*")
public class MessageServlet extends MessageBaseServlet {
    private MessageService messageService = new MessageServiceImpl();
    public void addMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取前端页面发送的message的json
        BufferedReader bf = req.getReader();
        String parms = bf.readLine();
        // 2. 将json转为Java对象
        Message message = JSON.parseObject(parms, Message.class);
        // 3. 调方法 完成添加
        messageService.addMessage(message);
        // 4. 响应数据
        resp.getWriter().write("success");
    }
    public void selectAllMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取message的list集合
        List<Message> _messages = messageService.sellectAllMessage();
        //  2.希望信息按照最新展示 也就是id越大 信息越新 将原来得到的集合 逆序排列
        Object[] objects = _messages.toArray();
        Object tmp;
        int length = objects.length - 1;
        for (int i = 0; i < objects.length / 2; i++, length--) {
            tmp = objects[i];
            objects[i] = objects[length];
            objects[length] =  tmp;
        }
        List messages = Arrays.asList(objects);
        // 3.将数据转为json  发送前端
        String toJSONString = JSON.toJSONString(messages);
        resp.setContentType("text/json;charset=utf8");
        resp.getWriter().write(toJSONString);
    }
    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取ajax发送的json格式的id
        BufferedReader bf = req.getReader();
        String parms = bf.readLine();
        // 2. 将id转为int
        Integer id = JSON.parseObject(parms, int.class);
        // 3. 执行删除方法
        messageService.deleteById(id);
        // 4. 响应数据
        resp.getWriter().write("success");
    }
    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取ajax发送的json格式的ids
        BufferedReader bf = req.getReader();
        String parms = bf.readLine();
        // 2. 将ids转为int
        int[] ids = JSON.parseObject(parms, int[].class);
        // 3. 执行删除方法
        messageService.deleteByIds(ids);
        // 4. 响应数据
        resp.getWriter().write("success");
    }
}
