package com.wangzhen.service.Animal;

import com.wangzhen.mapper.AnimalMapper;
import com.wangzhen.pojo.Animal;
import com.wangzhen.pojo.PageBean;
import com.wangzhen.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author wangzhen
 * @creat 15:48
 */
public class AnimalServiceImpl implements AnimalService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Animal> selectAll(){
        // 2.获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取映射mapper
        AnimalMapper mapper = sqlSession.getMapper(AnimalMapper.class);

        // 4.调用方法
        List<Animal> animals = mapper.selectAll();

        //资源关闭
        sqlSession.close();

        // 6.返回结果
        return animals;
    }

    @Override
    public void addAnimal(Animal animal) {
        // 2.获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取映射mapper
        AnimalMapper mapper = sqlSession.getMapper(AnimalMapper.class);

        // 4. 调用方法
        mapper.addAnimal(animal);

        //5. 提交事务
        sqlSession.commit();

        //6. 资源关闭
        sqlSession.close();
    }

    @Override
    public void updateAnimal(Animal animal) {
        // 2.获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取映射mapper
        AnimalMapper mapper = sqlSession.getMapper(AnimalMapper.class);

        // 4.调用方法
        mapper.updateAnimal(animal);

        //5. 提交事务
        sqlSession.commit();

        //6. 资源关闭
        sqlSession.close();
    }

    @Override
    public PageBean<Animal> selectByPage(int currentPage, int pageSize) {
        // 2.获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取映射mapper
        AnimalMapper mapper = sqlSession.getMapper(AnimalMapper.class);

        // 4.调用方法
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        List<Animal> animals = mapper.selectByPage(begin, size);

        // 5. 封装pageBean
        int totalCount = mapper.selectTotalCount(); // 总 记录条数
        PageBean<Animal> animalPageBean = new PageBean<>(totalCount, animals);

        // 6. 资源关闭
        sqlSession.close();

        // 7.返回结果
        return animalPageBean;
    }

    @Override
    public PageBean<Animal> selectByPageAndCondition(int currentPage, int pageSize, Animal animal) {
        // 2.获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取代理类mapper
        AnimalMapper mapper = sqlSession.getMapper(AnimalMapper.class);

        //4. 计算page 和 size
        int page = (currentPage - 1) * pageSize;
        int size = pageSize;

        // 5 设置格式
        if(animal.getAnimalName() != null && animal.getAnimalName() != ""){
            animal.setAnimalName("%" + animal.getAnimalName() + "%");
        }
        if(animal.getIsLive() != null && animal.getIsLive() != ""){
            animal.setIsLive("%" + animal.getIsLive() + "%");
        }
        if(animal.getDescription() != null && animal.getDescription() != ""){
            animal.setDescription("%" + animal.getDescription() + "%");
        }

        //6. 调用方法 查询集合
        List<Animal> rows = mapper.selectByPageAndCondition(page, size, animal);

        //7. 查询总记录了条数
        int totalCount = mapper.selectTotalCountByPageAndCondition();

        //8. 封装PageBean
        PageBean<Animal> pageBean = new PageBean<>(totalCount,rows);

        //9.资源关闭
        sqlSession.close();

        return pageBean;

    }

    @Override
    public void deleteById(int id) {
        // 2.获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取映射mapper
        AnimalMapper mapper = sqlSession.getMapper(AnimalMapper.class);

        // 4. 执行方法
        mapper.deleteById(id);

        // 5. 提交事务
        sqlSession.commit();

        // 6.资源关闭
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        // 2.获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取映射mapper
        AnimalMapper mapper = sqlSession.getMapper(AnimalMapper.class);

        // 4. 执行方法
        mapper.deleteByIds(ids);

        // 5. 提交事务
        sqlSession.commit();

        // 6.资源关闭
        sqlSession.close();
    }

    @Override
    public void updateById(Animal animal) {
        // 2.获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取映射mapper
        AnimalMapper mapper = sqlSession.getMapper(AnimalMapper.class);

        // 4. 执行方法
        mapper.updateById(animal);

        // 5. 提交事务
        sqlSession.commit();

        // 6.资源关闭
        sqlSession.close();
    }

    @Override
    public Animal selectAnimal(int id) {
        // 2.获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取映射mapper
        AnimalMapper mapper = sqlSession.getMapper(AnimalMapper.class);

        // 4. 执行方法
        Animal animal = mapper.selectAnimal(id);

        // 5.资源关闭
        sqlSession.close();

        return animal;
    }
}
