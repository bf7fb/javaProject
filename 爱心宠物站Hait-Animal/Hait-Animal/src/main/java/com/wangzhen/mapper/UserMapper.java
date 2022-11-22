package com.wangzhen.mapper;

import com.wangzhen.pojo.Message;
import com.wangzhen.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author wangzhen
 * @creat 16:52
 */
public interface UserMapper {
    /**
     * 根据用户名和密码查询用户对象
     * @param username
     * @param password
     * @return
     */
    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    @Select("select * from tb_user where username = #{username}")
    User selectByUsername(String username);

    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into tb_user values(null,#{username},#{password})")
    void add(User user);

    /**
     *  管理员登录
     */
    @Select("select * from tb_administrator where username = #{username} and password = #{password}")
    User selectAdministrator(@Param("username") String username, @Param("password") String password);

    /**
     *  查询点赞
     */
    @Select("select likes from tb_animal where id = #{id}")
    int selectLikes(int id);
    /**
     *  点赞
     */
    @Update("update tb_animal set likes = #{likes} where id = #{id}")
    void addLikes(@Param("id") int id, @Param("likes") int likes);
}
