package com.wangzhen.service.Message;

import com.alibaba.fastjson.JSON;
import com.wangzhen.mapper.AnimalMapper;
import com.wangzhen.mapper.MessageMapper;
import com.wangzhen.mapper.UserMapper;
import com.wangzhen.pojo.Message;
import com.wangzhen.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * @author wangzhen
 * @creat 18:21
 */
public class MessageServiceImpl implements MessageService{
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public void addMessage(Message message) {
        // 1.获取sqlsessionfactory

        // 2. 获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取代理类mapper
        MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);

        // 4. 调方法
        messageMapper.addMessage(message);

        // 5.提交事务
        sqlSession.commit();

        //6. 资源关闭
        sqlSession.close();
    }

    @Override
    public List<Message> sellectAllMessage() {
        // 1.获取sqlsessionfactory

        // 2. 获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取代理类mapper
        MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);

        // 4. 调方法
        List<Message> messages = messageMapper.sellectAllMessage();

        //6. 资源关闭
        sqlSession.close();

        // 7. 返回结果
        return messages;
    }

    @Override
    public void deleteById(int id) {
        // 2.获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取映射mapper
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);

        // 4. 执行方法
        mapper.deleteById(id);

        // 5. 提交事务
        sqlSession.commit();

        // 6.资源关闭
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        // 2.获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取映射mapper
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);

        // 4. 执行方法
        mapper.deleteByIds(ids);

        // 5. 提交事务
        sqlSession.commit();

        // 6.资源关闭
        sqlSession.close();
    }

}
