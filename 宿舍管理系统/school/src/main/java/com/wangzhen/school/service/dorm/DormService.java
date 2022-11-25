package com.wangzhen.school.service.dorm;

import com.wangzhen.school.pojo.Dorm;

import java.util.List;

/**
 * @author wz
 * @ClassName DormService
 * @date 2022/11/3 17:54
 * @Description 宿舍接口
 */
public interface DormService {
    /**
     *  查询宿舍所有信息
     */
    public List<Dorm> selectAll();

    /**
     * 根据id查看
     */
    public Dorm selectById(Integer dormId);

    /**
     *  添加一个宿舍
     */
    public void addDorm(Dorm dorm);

    /**
     * 删除一个宿舍
     */
    void deleteDorm(Integer dormId);

    /**
     * 修改一个宿舍
     */
    void updateDom(Dorm dorm);

    /**
     * 条件查询
     */
    List<Dorm> selectByCondition(Dorm dorm);
}
