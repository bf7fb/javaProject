package com.wangzhen.music.pojo;

/**
 * @author wz
 * @ClassName Music
 * @date 2022/12/6 12:41
 * @Description TODO
 */
public class Music {
    private Integer musicId;
    private String musicName;
    private String musicAuthor;
    private String musicAddress;

    public Music() {
    }

    public Music(Integer musicId, String musicName, String musicAuthor, String musicAddress) {
        this.musicId = musicId;
        this.musicName = musicName;
        this.musicAuthor = musicAuthor;
        this.musicAddress = musicAddress;
    }

    public Integer getMusicId() {
        return musicId;
    }

    public void setMusicId(Integer musicId) {
        this.musicId = musicId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicAuthor() {
        return musicAuthor;
    }

    public void setMusicAuthor(String musicAuthor) {
        this.musicAuthor = musicAuthor;
    }

    public String getMusicAddress() {
        return musicAddress;
    }

    public void setMusicAddress(String musicAddress) {
        this.musicAddress = musicAddress;
    }

    @Override
    public String toString() {
        return "Music{" +
                "musicId=" + musicId +
                ", musicName='" + musicName + '\'' +
                ", musicAuthor='" + musicAuthor + '\'' +
                ", musicAddress='" + musicAddress + '\'' +
                '}';
    }
}
