package com.wangzhen.music.service;

import com.wangzhen.music.pojo.User;

/**
 * @author wz
 * @ClassName UserService
 * @date 2022/12/6 15:13
 * @Description TODO
 */
public interface UserService {
    boolean login(User user);

    boolean register(User user);

    User selectByUserName(String username);

    /**
     * 管理员登录
     */
    boolean adminLogIn(User user);
}
