package com.wangzhen.service.User;

import com.wangzhen.pojo.Message;
import com.wangzhen.pojo.User;

import java.util.List;

/**
 * @author wangzhen
 * @creat 12:13
 */
public interface UserService {
    /**
     *  查询用户输入的账号密码 数据库是否存在
     * @param username
     * @param password
     * @return
     */
    public User select(String username, String password);

    /**
     *  注册
     */
    public boolean register(User user);

    /**
     *  管理员登陆
     */
    public User selectAdministrator(String username, String password);

    /**
     *  查询点赞
     */
    int selectLikes(int id);

    /**
     *  实现点赞功能
     */
    void addLikes(int id);
}
