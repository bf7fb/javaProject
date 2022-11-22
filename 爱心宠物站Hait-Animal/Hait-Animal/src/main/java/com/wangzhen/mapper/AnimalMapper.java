package com.wangzhen.mapper;

import com.wangzhen.pojo.Animal;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author wangzhen
 * @creat 15:38
 */
public interface AnimalMapper {
    /**
     *  查询所有
     * @return
     */
    @Select("select * from tb_animal")
    @ResultMap("animalResultMap")
    List<Animal> selectAll();

    /**
     * 添加
     */
    @Insert("insert into tb_animal values(null,#{animalName},#{sex},#{isLive},#{description},null)")
    void addAnimal(Animal animal);

    /**
     * 修改
     */
    void updateAnimal(Animal animal);

    /**
     * 分页查询
     */
    @Select("select * from tb_animal limit #{begin} , #{size} ")
    @ResultMap("animalResultMap")
    List<Animal> selectByPage(@Param("begin") int begin, @Param("size") int size);

    /**
     * 计算记录条总数
     */
    @Select("select count(*) from tb_animal")
    int selectTotalCount();

    /**
     *  条件 且 分页 查询
     */
    List<Animal> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("animal") Animal animal);

    /**
     *  条件 且 分页 查询 得到的结果记录条数
     *  因为要把查询结果 封装为pageBean 所以这里要获取totalcount：一个页面展示几条数据
     */
    int selectTotalCountByPageAndCondition();

    /**
     *  根据id删除
     */
    @Delete("delete from tb_animal where id = #{id}")
    void deleteById(int id);

    /**
     * 批量删除
     */
    void deleteByIds(@Param("ids")int[] ids);

    /**
     * 修改数据
     */
    void updateById(Animal animal);

    /**
     *  查看具体动物
     */
    @Select("select * from tb_animal where id = #{id}")
    @ResultMap("animalResultMap")
    Animal selectAnimal(int id);
}

