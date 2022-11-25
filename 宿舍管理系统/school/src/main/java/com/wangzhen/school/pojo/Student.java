package com.wangzhen.school.pojo;

/**
 * @author wz
 * @ClassName Student
 * @date 2022/11/3 17:23
 * @Description 学生实体类
 */
public class Student {
    private Integer stuId ;
    private String stuName;
    private String stuSex;
    private String stuAge;
    // 学生班级名称
    private String stuClass;
    // 学生学号
    private Integer stuNum;
    // 图片地址
    private String stuPhoto;
    // 学生所属的宿舍的匹配id
    private Integer stuDormId;

    public Student() {
    }

    public Student(String stuName, String stuSex, String stuAge, String stuClass, Integer stuNum, Integer stuDormId) {
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuAge = stuAge;
        this.stuClass = stuClass;
        this.stuNum = stuNum;
        this.stuDormId = stuDormId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuAge() {
        return stuAge;
    }

    public void setStuAge(String stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public Integer getStuNum() {
        return stuNum;
    }

    public void setStuNum(Integer stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuPhoto() {
        return stuPhoto;
    }

    public void setStuPhoto(String stuPhoto) {
        this.stuPhoto = stuPhoto;
    }

    public Integer getStuDormId() {
        return stuDormId;
    }

    public void setStuDormId(Integer stuDormId) {
        this.stuDormId = stuDormId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuAge='" + stuAge + '\'' +
                ", stuClass='" + stuClass + '\'' +
                ", stuNum=" + stuNum +
                ", stuPhoto='" + stuPhoto + '\'' +
                ", stuDormId=" + stuDormId +
                '}';
    }
}
