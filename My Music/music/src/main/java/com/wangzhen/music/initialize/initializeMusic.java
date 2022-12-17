package com.wangzhen.music.initialize;

import com.wangzhen.music.mapper.MusicMapper;
import com.wangzhen.music.pojo.Music;
import com.wangzhen.music.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.File;
import java.util.UUID;

/**
 * @author wz
 * @ClassName initialize
 * @date 2022/12/7 17:29
 * @Description 项目初始阶段 批量导入歌曲
 */

public class initializeMusic {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public void inital() {
        String path = "C:\\Users\\wangzhen\\Desktop\\测试用例";        //要遍历的路径
        File file = new File(path);        //获取其file对象
        File[] fs = file.listFiles();    //遍历path下的文件和目录，放在File数组中
        for (int k = 0; k < fs.length; k++) {//遍历File[]数组

            String originName = fs[k].getName();

            int i = originName.indexOf("-");
            int i1 = originName.lastIndexOf(".");

            String musicName = originName.substring(0, i);
            String musicAuthor = originName.substring(i+1, i1);

            String uuid = UUID.randomUUID().toString() + ".mp3";
            fs[k].renameTo(new File("D:\\code java\\MyJavaProject\\music\\src\\main\\webapp\\music\\" + uuid ));

            Music music = new Music();
            music.setMusicName(musicName);
            music.setMusicAuthor(musicAuthor);

            music.setMusicAddress(uuid);

            // 原生方式获取mapper
            SqlSession sqlSession = sqlSessionFactory.openSession();
            MusicMapper musicMapper = sqlSession.getMapper(MusicMapper.class);
            musicMapper.addMusicAdmin(music);
            sqlSession.commit();
            sqlSession.close();

        }
        System.out.println("共有" + fs.length + "首歌曲");

    }

    public static void main(String[] args) {
        initializeMusic initializeMusic = new initializeMusic();
        initializeMusic.inital();
    }
}
