package com.wangzhen.music.service;

import com.wangzhen.music.pojo.Music;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wz
 * @ClassName MusicService
 * @date 2022/12/6 12:50
 * @Description TODO
 */
public interface MusicService {
    /**
     * 条件查询
     */
    List<Music> selectByCondition(String message);

    Music selectById(Integer musicId);

    /**
     * 将音乐添加到我的喜欢
     */
    void addMyLikes(Integer userId, Integer musicId);

    /**
     * 查看我收藏的音乐
     */
    List<Music> selectMyLikes(Integer userId);

    /**
     * 根据id查询某人收藏的某手首歌曲
     * @param userId
     * @param musicId
     * @return
     */
    Music selectMyMusicById(Integer userId, Integer musicId);

    /**
     * 删除收藏
     * @param userId
     * @param musicId
     */
    void deleteMyMusicById(Integer userId, Integer musicId);

    /**
     * 查找收藏的某首歌曲
     * @param userId
     * @param message
     * @return
     */
    List<Music> selectByConditionInMyLikes(@Param("userId") Integer userId, @Param("message") String message);

    /**
     * 管理员根据id删除音乐
     * @param musicId
     */
    void deleteMusicByIdAdmin(Integer musicId);

    /**
     * 管理员查询所有音乐
     */
    List<Music> selectAllMusicAdmin();

    /**
     * 管理员添加音乐
     */
    void addMusicAdmin(Music music);

}
