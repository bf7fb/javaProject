package com.wangzhen.school.pojo;

/**
 * @author wz
 * @ClassName Dorm
 * @date 2022/11/3 17:51
 * @Description 宿舍实体类
 */
public class Dorm {
    private Integer dormId;
    private String dormName;

    public Dorm() {
    }

    public Dorm(Integer dormId, String dormName) {
        this.dormId = dormId;
        this.dormName = dormName;
    }

    public Integer getDormId() {
        return dormId;
    }

    public void setDormId(Integer dormId) {
        this.dormId = dormId;
    }

    public String getDormName() {
        return dormName;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName;
    }

    @Override
    public String toString() {
        return "Dorm{" +
                "dormId=" + dormId +
                ", dormName='" + dormName + '\'' +
                '}';
    }
}
