package com.wangzhen.school.service.dorm;

import com.wangzhen.school.mapper.DormMapper;
import com.wangzhen.school.pojo.Dorm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wz
 * @ClassName DormServiceImpl
 * @date 2022/11/3 17:54
 * @Description 宿舍接口实现类 完成对宿舍信息的增删改查
 */
@Service
@Transactional
public class DormServiceImpl implements DormService{
    @Autowired
    private DormMapper dormMapper;

    public List<Dorm> selectAll() {
        // 查询所有
        List<Dorm> dorms = dormMapper.selectAll();
        // 返回结果
        return dorms;
    }

    public Dorm selectById(Integer dormId) {
        Dorm dorm = dormMapper.selectById(dormId);
        return dorm;
    }

    public void addDorm(Dorm dorm) {
        dormMapper.addDorm(dorm);
    }

    public void deleteDorm(Integer dormId) {
        dormMapper.deleteDorm(dormId);
    }

    public void updateDom(Dorm dorm) {
        dormMapper.updateDorm(dorm);
    }

    public List<Dorm> selectByCondition(Dorm dorm) {
        String newDormName = "%" + dorm.getDormName() +"%";
        dorm.setDormName(newDormName);
        List<Dorm> dorms = dormMapper.selecyByCondition(dorm);
        return dorms;
    }


}
