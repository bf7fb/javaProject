package com.wangzhen.pojo;

/**
 * @author wangzhen
 * @creat 15:41
 */
public class Animal {
    private Integer id;
    private String animalName;
    private String sex;
    private String isLive;
    private String description;
    private Integer likes;

    public Animal() {
    }

    public Animal(String animalName, String sex, String isLive, String description, Integer likes) {
        this.animalName = animalName;
        this.sex = sex;
        this.isLive = isLive;
        this.description = description;
        this.likes = likes;
    }

    public Animal(Integer id, String animalName, String sex, String isLive, String description, Integer likes) {
        this.id = id;
        this.animalName = animalName;
        this.sex = sex;
        this.isLive = isLive;
        this.description = description;
        this.likes = likes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIsLive() {
        return isLive;
    }

    public void setIsLive(String isLive) {
        this.isLive = isLive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", animalName='" + animalName + '\'' +
                ", sex='" + sex + '\'' +
                ", isLive='" + isLive + '\'' +
                ", description='" + description + '\'' +
                ", likes=" + likes +
                '}';
    }
}
