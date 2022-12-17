import com.wangzhen.music.mapper.MusicMapper;
import com.wangzhen.music.pojo.Music;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.UUID;

/**
 * @author wz
 * @ClassName test
 * @date 2022/12/6 17:12
 * @Description TODO
 */
public class test {
    @Autowired
    private MusicMapper musicMapper;
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
            fs[k].renameTo(new File("C:\\Users\\wangzhen\\Desktop" + uuid ));

            Music music = new Music();
            music.setMusicName(musicName);
            music.setMusicAuthor(musicAuthor);

            music.setMusicAddress(uuid);

            musicMapper.addMusicAdmin(music);


        }
        System.out.println("共有" + fs.length + "首歌曲");

    }

    public static void main(String[] args) {
        test test = new test();
        test.inital();
    }
}
