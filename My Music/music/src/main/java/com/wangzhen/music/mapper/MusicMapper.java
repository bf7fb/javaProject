package com.wangzhen.music.mapper;

import com.wangzhen.music.pojo.Music;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wz
 * @ClassName MusicMapper
 * @date 2022/12/6 12:44
 * @Description TODO
 */
public interface MusicMapper {

    /**
     * 模糊查询
     * @param message
     * @return
     */
    @Select("select * from tb_music where music_name like #{message} or music_author like #{message}")
    List<Music> selectByCondition(String message);

    /**
     * 在音乐表中根据id查询
     * @param musicId
     * @return
     */
    @Select("select * from tb_music where music_id = #{musicId}")
    Music selectById(Integer musicId);

    /**
     * 将音乐添加到我的喜欢
     */
    @Insert("insert into tb_relations(user_id,music_id) values(#{userId},#{musicId})")
    void addMyLikes(@Param("userId") Integer userId, @Param("musicId") Integer musicId);

    /**
     *  查看我收藏的音乐
     */
    @Select("select  " +
            "t2.* " +
            "from tb_user t1, tb_music t2, tb_relations t3 " +
            "where " +
            "t1.user_id = t3.user_id and t2.music_id = t3.music_id and t3.user_id = #{userId};")
    List<Music> selectMyLikes(Integer userId);

    /**
     * 根据id查询某人收藏某首歌曲
     * @param userId
     * @param musicId
     * @return
     */
    @Select("select  t2.* " +
            "from tb_user t1, tb_music t2, tb_relations t3 " +
            "where t1.user_id = t3.user_id and t2.music_id = t3.music_id " +
            "and t3.user_id = #{userId} and t3.music_id = #{musicId};")
    Music selectMyMusicById(@Param("userId") Integer userId, @Param("musicId") Integer musicId);

    /**
     * 将收藏的音乐删除
     */
    @Delete("delete from tb_relations where user_id = #{userId} and music_id = #{musicId}")
    void deleteMyMusicById(@Param("userId") Integer userId, @Param("musicId") Integer musicId);

    /**
     * 根据输入信息搜索收藏的某首歌曲
     */
    @Select("select t2.* " +
            "from tb_user t1, tb_music t2, tb_relations t3 " +
            "where t1.user_id = t3.user_id and t2.music_id = t3.music_id " +
            "and t3.user_id = #{userId} and t2.music_name like #{message}")
    List<Music> selectByConditionInMyLikes(@Param("userId") Integer userId,@Param("message") String message);

    /**
     * 管理员删除音乐
     */
    @Delete("delete from tb_music where music_id = #{musicId}")
    void deleteMusicById(Integer musicId);

    /**
     * 管理员查询所有
     */
    @Select("select * from tb_music")
    List<Music> selectAllMusicAdmin();

    /**
     * 添加音乐
     */
    @Insert("insert into tb_music(music_name,music_author,music_address) " +
            "values(#{musicName},#{musicAuthor},#{musicAddress})")
    void addMusicAdmin(Music music);



}
