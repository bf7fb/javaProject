package com.wangzhen.pojo;

/**
 * @author wangzhen
 * @creat 16:18
 */
public class Message {
    private int id;
    private String name;
    private String tel;
    private String description;

    public Message() {
    }

    public Message(String name, String tel, String description) {
        this.name = name;
        this.tel = tel;
        this.description = description;
    }

    public Message(int id, String name, String tel, String description) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
