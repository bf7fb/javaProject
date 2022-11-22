package com.wangzhen.mapper;

import com.wangzhen.pojo.Message;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wangzhen
 * @creat 18:18
 */
public interface MessageMapper {
    /**
     *  联系我们
     */
    @Insert("insert into tb_message values(null,#{name},#{tel},#{description})")
    void addMessage(Message message);

    /**
     *  查看联系我们留言的 全部信息
     */
    @Select("select * from tb_message")
    List<Message> sellectAllMessage();

    /**
     *  删除单个信息
     */
    @Delete("delete from tb_message where id = #{id}")
    void deleteById(int id);

    /**
     *  批量删除留言
     */

    void deleteByIds(@Param("ids")int[] ids);
}
