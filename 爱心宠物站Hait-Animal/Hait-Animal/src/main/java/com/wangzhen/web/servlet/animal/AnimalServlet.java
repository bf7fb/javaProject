package com.wangzhen.web.servlet.animal;

import com.alibaba.fastjson.JSON;
import com.wangzhen.pojo.Animal;
import com.wangzhen.pojo.PageBean;
import com.wangzhen.service.Animal.AnimalService;
import com.wangzhen.service.Animal.AnimalServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * @author wangzhen
 * @creat 15:50
 */
@WebServlet("/animal/*")
public class AnimalServlet extends BaseServlet{
    AnimalService animalService = new AnimalServiceImpl();
    /**
     *  查询所有
     */
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.查询所有
        List<Animal> animals = animalService.selectAll();
        // 2。将数据转为json
        String toJSONString = JSON.toJSONString(animals);
        //3.发送给前端页面  因为有中文要设置字符集
        resp.setContentType("text/json;charset=utf8");
        resp.getWriter().write(toJSONString);
    }
    /**
     * 添加动物
     */
    public void addAnimal(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取表单提交数据
        BufferedReader bf = req.getReader();
        String params = bf.readLine();
        // 2.转为java对象
        Animal animal = JSON.parseObject(params, Animal.class);
        // 3.调用方法 完成添加
        animalService.addAnimal(animal);
        // 4、响应数据
        resp.getWriter().write("success");
    }
    /**
     *  修改动物信息
     */
    public void updateAnimal(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取表单提交数据
        BufferedReader bf = req.getReader();
        String params = bf.readLine();
        // 2.转为java对象
        Animal animal = JSON.parseObject(params, Animal.class);
        // 3.调用方法 完成添加
        animalService.updateAnimal(animal);
        // 4、响应数据
        resp.getWriter().write("success");
    }
    /**
     * 分页查询
     */
    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取当前页码 和 每页显示条数
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        // 2. 将获取到的String字符串转为int
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        // 3.调用brandService完成查询
        PageBean<Animal> animalPageBeanPageBean = animalService.selectByPage(currentPage, pageSize);
        // 4.将数据转为json
        String jsonString = JSON.toJSONString(animalPageBeanPageBean);
        //5.发送给前端页面  因为有中文要设置字符集
        resp.setContentType("text/json;charset=utf8");
        resp.getWriter().write(jsonString);
    }
    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取当前页码 和 每页显示条数
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        // 2.1 将获取到的String字符串转为int
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        // 2.2 获取页面的brand的json数据
        BufferedReader br = req.getReader();
        String parms = br.readLine();
        Animal animal = JSON.parseObject(parms, Animal.class);
        // 3.调用brandService完成分页查询
        PageBean<Animal> animalPageBean = animalService.selectByPageAndCondition(currentPage, pageSize, animal);
        // 4.将数据转为json
        String jsonString = JSON.toJSONString(animalPageBean);
        //5.发送给前端页面  因为有中文要设置字符集
        resp.setContentType("text/json;charset=utf8");
//        System.out.println(animalPageBean.getRows());
        resp.getWriter().write(jsonString);
    }
    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取ajax发送的json格式的id
        BufferedReader bf = req.getReader();
        String parms = bf.readLine();
        // 2. 将id转为int
        Integer id = JSON.parseObject(parms, int.class);
        // 3. 执行删除方法
        animalService.deleteById(id);
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
        animalService.deleteByIds(ids);
        // 4. 响应数据
        resp.getWriter().write("success");
    }
    public void updateById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取ajax发送的json格式的animal
        BufferedReader bf = req.getReader();
        String parms = bf.readLine();
        // 2. 转为java对象
        Animal animal = JSON.parseObject(parms, Animal.class);
        // 3. 执行修改改方法
        animalService.updateById(animal);
        // 4. 响应数据
        resp.getWriter().write("success");
    }
    public void selectAnimal(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取ajax发送的json格式的id
        BufferedReader bf = req.getReader();
        String parms = bf.readLine();
        // 2. 将id转为int
        Integer id = JSON.parseObject(parms, int.class);
        // 3. 执行删除方法
        Animal animal = animalService.selectAnimal(id);
        // 不会写vue

        // 4. 将animal转成json  发送给前端
//        String toJSONString = JSON.toJSONString(animal);
//        // 5. 响应数据
//        resp.getWriter().write(toJSONString);

        // 只好写jsp了
        // 4. 将animal存储在session域中
        HttpSession session = req.getSession();
        session.setAttribute("animal", animal);

        // 5.将结果转发到jsp
        // 但使用ajax请求 后台是无法跳转到jsp页面
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/selectAnimal.jsp");

    }

}
