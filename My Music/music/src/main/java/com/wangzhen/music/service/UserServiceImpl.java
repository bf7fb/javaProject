package com.wangzhen.music.service;

import com.wangzhen.music.mapper.UserMapper;
import com.wangzhen.music.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wz
 * @ClassName UserServiceImpl
 * @date 2022/12/6 15:13
 * @Description TODO
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    public boolean login(User user) {
        User loginUser = userMapper.login(user);
        if (loginUser == null){
            // 登录失败
            return false;
        }
        return true;
    }

    public boolean register(User user) {
        User registerUser = userMapper.checkUser(user);
        if(registerUser == null){
            // 数据库中不存在 则注册成功  处理误输入空格字符
            String password = user.getPassword().trim();
            user.setPassword(password);
            userMapper.register(user);
            return true;
        }
        // 否则注册失败
        return false;
    }

    public User selectByUserName(String username) {
        User user = userMapper.selectByName(username);
        return user;
    }

    public boolean adminLogIn(User user) {
        User adminUser = userMapper.adminLogIn(user);
        if (adminUser == null){
            return false;
        }
        return true;
    }


}
