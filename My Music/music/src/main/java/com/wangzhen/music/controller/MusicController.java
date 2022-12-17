package com.wangzhen.music.controller;

import com.wangzhen.music.pojo.Music;
import com.wangzhen.music.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author wz
 * @ClassName MusicController
 * @date 2022/12/7 19:22
 * @Description TODO
 */
@Controller
public class MusicController {
    @Autowired
    private MusicService musicServiceImpl;

    /**
     * 用户查找歌曲
     * @param message
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectByCondition", method = RequestMethod.POST)
    public String selectByCondition(String message, Model model){
        List<Music> musicList = musicServiceImpl.selectByCondition(message);
        model.addAttribute("musics",musicList);
        return "music";
    }

    /**
     * 查看用户收藏的音乐
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectMyLikes/{userId}", method = RequestMethod.GET)
    public String selectMyLikes(@PathVariable("userId") Integer userId, Model model){
        List<Music> musicList = musicServiceImpl.selectMyLikes(userId);
        model.addAttribute("myMusics",musicList);
        return "myLikes";
    }

    /**
     * 将音乐添加到用户收藏
     * @param userId
     * @param musicId
     * @param model
     * @return
     */
    @RequestMapping(value = "/addMyLikes/{userId}/{musicId}", method = RequestMethod.GET)
    public String addMyLikes( @PathVariable("userId") Integer userId,
                              @PathVariable("musicId") Integer musicId,
                              Model model){

        // 查询前判断这首歌曲是否存在用户收藏中
        Music music = musicServiceImpl.selectMyMusicById(userId, musicId);
        if (music == null){
            // 不存在 实现添加
            musicServiceImpl.addMyLikes(userId, musicId);
            return "redirect:/selectMyLikes/" + userId;
        }
        // 已经存在 则返回
        model.addAttribute("addMessage","添加失败,该歌曲已经存在您的喜欢中咯");
        return "redirect:/selectMyLikes/" + userId;
    }

    /**
     * 具体查看某首音乐相关信息 点击播放按钮
     * @param musicId
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectMusic/{musicId}", method = RequestMethod.GET)
    public String selectById(@PathVariable("musicId") Integer musicId,Model model){
        Music music = musicServiceImpl.selectById(musicId);
        model.addAttribute("selectMusic",music);
        return "selectMusic";
    }

    /**
     * 删除某人收藏的音乐
     * @param userId
     * @param musicId
     * @return
     */
    @RequestMapping(value = "/deleteMyMusicById/{userId}/{musicId}")
    public String deleteMyMusicById(@PathVariable("userId") Integer userId,
                                    @PathVariable("musicId") Integer musicId){

        musicServiceImpl.deleteMyMusicById(userId, musicId);
        return "redirect:/selectMyLikes/" + userId;

    }

    /**
     * 在用户收藏中 查找某首歌曲
     * @param userId
     * @param message
     * @param model
     * @return
     */
    @RequestMapping("/selectByConditionInMyLikes/{userId}")
    public String selectByConditionInMyLikes(@PathVariable("userId") Integer userId,
                                             String message, Model model){

        List<Music> musicList = musicServiceImpl.selectByConditionInMyLikes(userId, message);
        model.addAttribute("myMusics",musicList);
        return "myLikes";

    }

    /**
     * 管理员登录 展示所有数据
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectAllMusicAdmin", method = RequestMethod.GET)
    public String selectAllMusicAdmin(Model model){
        List<Music> musicList = musicServiceImpl.selectAllMusicAdmin();
        model.addAttribute("musicListAdmin",musicList);
        return "adminMusic";
    }

    /**
     * 管理员删除某首音乐
     * @param musicId
     * @return
     */
    @RequestMapping(value = "/deleteMusicById/{musicId}")
    public String deleteMusicByIdAdmin(@PathVariable("musicId") Integer musicId){
        musicServiceImpl.deleteMusicByIdAdmin(musicId);
        return "redirect:/selectAllMusicAdmin";
    }

    /**
     * 管理员查询某首歌曲
     * @param message
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectByConditionAdmin", method = RequestMethod.POST)
    public String selectByConditionAdmin(String message, Model model){
        List<Music> musicList = musicServiceImpl.selectByCondition(message);
        model.addAttribute("musicListAdmin",musicList);
        return "adminMusic";
    }

    /**
     * 管理员上传文件
     * @param music
     * @param mp3
     * @param session
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/addMusicAdmin", method = RequestMethod.POST)
    public String addMusicAdmin(Music music, MultipartFile mp3, HttpSession session, Model model)
            throws IOException {

        // 没有上传文件 则返回
        if (mp3.getSize() == 0){
            model.addAttribute("addMusicMessageAdmin","添加失败~请选择文件");
            return "redirect:/to/addMusicAdmin";
        }
        System.out.println(mp3);
        // 获取上传的文件名称
        String fileName = mp3.getOriginalFilename();

        // 处理文件同名问题
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + hzName;

        // 获取服务器中photo目录  默认在webapp下
        ServletContext servletContext = session.getServletContext();
        String musicPath = servletContext.getRealPath("music");
        File file = new File(musicPath);
        if(!file.exists()){
            file.mkdir();
        }
        String finalPath = musicPath + File.separator + fileName;
        // 实现上传
        mp3.transferTo(new File(finalPath));

        // 数据库存储 uuid.MP3
        music.setMusicAddress(fileName);

        // 数据库实现添加
        musicServiceImpl.addMusicAdmin(music);

        return "redirect:/selectAllMusicAdmin";

    }

}
