package com.wangzhen.service.User;

import com.wangzhen.mapper.UserMapper;
import com.wangzhen.pojo.Message;
import com.wangzhen.pojo.User;
import com.wangzhen.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author wangzhen
 * @creat 12:14
 */
public class UserServiceImpl implements UserService{
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public User select(String username, String password) {
        // 1.获取sqlsessionfactory

        // 2. 获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取代理类mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //4. 查询所有
        User user = userMapper.select(username, password);

        //5. 资源关闭
        sqlSession.close();

        //6. 返回结果
        return user;
    }

    public boolean register(User user) {
        // 1.获取sqlsessionfactory

        // 2. 获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取代理类mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //4. 判断用户名是否存在 及密码是否为空
        User u = userMapper.selectByUsername(user.getUsername());
        if (u == null) {
            if (user.getPassword() != null && user.getUsername() != null) {
                // 注册成功
                userMapper.add(user);
                // 提交事务
                sqlSession.commit();
            }
        }
        //5. 资源关闭
        sqlSession.close();

        //6. 返回结果
        return u == null && !"".equals(user.getPassword()) && !"".equals(user.getUsername());

    }

    @Override
    public User selectAdministrator(String username, String password) {
        // 1.获取sqlsessionfactory

        // 2. 获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取代理类mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //4. 查询所有
        User user = userMapper.selectAdministrator(username, password);

        //5. 资源关闭
        sqlSession.close();

        //6. 返回结果
        return user;
    }

    @Override
    public int selectLikes(int id) {
        // 1.获取sqlsessionfactory

        // 2. 获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取代理类mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 4.调用方法
        int likes = userMapper.selectLikes(id);

        // 5.关闭资源
        sqlSession.close();

        // 6.返回结果
        return likes;
    }

    @Override
    public void addLikes(int id) {
        // 1.获取sqlsessionfactory

        // 2. 获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取代理类mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 4. 掉方法查询likes  应该加判断
//         同一用户点赞取消 应该为原数修改
        int likes = userMapper.selectLikes(id) + 1;

        // 5. 调方法完成添加
        userMapper.addLikes(id,likes);

        // 6. 提交事务
        sqlSession.commit();

        // 7. 资源关闭
        sqlSession.close();
    }


}
