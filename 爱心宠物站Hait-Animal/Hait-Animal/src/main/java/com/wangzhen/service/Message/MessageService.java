package com.wangzhen.service.Message;

import com.wangzhen.pojo.Message;

import java.util.List;

/**
 * @author wangzhen
 * @creat 18:21
 */
public interface MessageService {
    /**
     *  联系我们
     */
    void addMessage(Message message);

    /**
     * 查询所有留言
     */
    List<Message> sellectAllMessage();

    /**
     *  根据id单个删除信息
     */
    void deleteById(int id);

    /**
     *  根据id 批量删除
     */
    void deleteByIds(int[] ids);
}
