package com.wangzhen.service.Animal;

import com.wangzhen.pojo.Animal;
import com.wangzhen.pojo.PageBean;

import java.util.List;

/**
 * @author wangzhen
 * @creat 16:38
 */
public interface AnimalService {
    /**
     * 查询所有
     * @return
     */
    List<Animal> selectAll();
    /**
     * 添加动物
     */
    void addAnimal(Animal animal);
    /**
     * 修改动物
     */
    void updateAnimal(Animal animal);
    /**
     * 分页查询
     */
    PageBean<Animal> selectByPage(int currentPage,int pageSize);
    /**
     * 条件 且 分页查询
     */
    PageBean<Animal> selectByPageAndCondition(int currentPage,int pageSize,Animal animal);
    /**
     *  根据id删除
     */
    void deleteById(int id);
    /**
     *  根据id批量删除
     */
    void deleteByIds(int[] ids);

    /**
     *  修改动物
     * @param animal
     */
    void updateById(Animal animal);
    /**
     *  查看具体动物
     */
    Animal selectAnimal(int id);

}
