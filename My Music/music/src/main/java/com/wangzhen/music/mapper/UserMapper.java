package com.wangzhen.music.mapper;

import com.wangzhen.music.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author wz
 * @ClassName UserMapper
 * @date 2022/12/6 12:44
 * @Description TODO
 */
public interface UserMapper {
    /**
     * 登录
     */
    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User login(User user);

    /**
     *  注册前查询是否有重复账号
     */
    @Select("select * from tb_user where username = #{username}")
    User checkUser(User user);

    /**
     * 注册
     */
    @Insert("insert into tb_user(username,password) values(#{username},#{password})")
    void register(User user);

    /**
     * 根据username查询
     */
    @Select("select * from tb_user where username = #{username}")
    User selectByName(String username);

    /**
     * 管理员登录
     */
    @Select("select * from tb_admin where username = #{username} and password = #{password}")
    User adminLogIn(User user);
}
