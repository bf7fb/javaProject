package com.wangzhen.music.service;

import com.wangzhen.music.mapper.MusicMapper;
import com.wangzhen.music.pojo.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wz
 * @ClassName MusicServiceImpl
 * @date 2022/12/7 19:17
 * @Description TODO
 */
@Service
@Transactional
public class MusicServiceImpl implements MusicService{
    @Autowired
    private MusicMapper musicMapper;

    /**
     * 用户条件查询
     * @param message
     * @return
     */
    public List<Music> selectByCondition(String message) {
        message = "%" + message + "%";
        List<Music> musics = musicMapper.selectByCondition(message);
        return musics;
    }

    /**
     * 根据id查询某首音乐 当某首音乐被选中播放
     * @param musicId
     * @return
     */
    public Music selectById(Integer musicId) {
        Music music = musicMapper.selectById(musicId);
        return music;
    }

    /**
     * 将音乐添加到某人收藏中
     * @param userId
     * @param musicId
     */
    public void addMyLikes(Integer userId, Integer musicId) {
        musicMapper.addMyLikes(userId, musicId);
    }

    /**
     * 查询我的收藏
     * @param userId
     * @return
     */
    public List<Music> selectMyLikes(Integer userId) {
        List<Music> musics = musicMapper.selectMyLikes(userId);
        return musics;
    }

    /**
     * 根据id查询我收藏的某首音乐
     * @param userId
     * @param musicId
     * @return
     */
    public Music selectMyMusicById(Integer userId, Integer musicId) {
        Music musics = musicMapper.selectMyMusicById(userId, musicId);
        return musics;
    }

    /**
     * 根据id删除我收藏的某首音乐
     * @param userId
     * @param musicId
     */
    public void deleteMyMusicById(Integer userId, Integer musicId) {
        musicMapper.deleteMyMusicById(userId, musicId);
    }

    /**
     * 在收藏中条件查询音乐
     * @param userId
     * @param message
     * @return
     */
    public List<Music> selectByConditionInMyLikes(Integer userId, String message) {
        List<Music> musicList = musicMapper.selectByConditionInMyLikes(userId, "%" + message + "%");
        return musicList;
    }

    /**
     * 管理员删除音乐
     * @param musicId
     */
    public void deleteMusicByIdAdmin(Integer musicId) {
        musicMapper.deleteMusicById(musicId);
    }

    /**
     * 管理员查询所有
     * @return
     */
    public List<Music> selectAllMusicAdmin() {
        List<Music> musicList = musicMapper.selectAllMusicAdmin();
        return musicList;
    }

    /**
     * 管理员添加音乐
     * @param music
     */
    public void addMusicAdmin(Music music) {
        musicMapper.addMusicAdmin(music);
    }


}
