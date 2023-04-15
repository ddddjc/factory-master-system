package com.djc.service.impl;

import com.djc.entity.MaintenanceFinishUmmary;
import com.djc.mapper.MaintenanceFinishUmmaryMapper;
import com.djc.service.MaintenanceFinishUmmaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 维护完成汇总(MaintenanceFinishUmmary)表服务实现类
 *
 * @author djc
 * @since 2023-04-15 15:28:48
 */
@Service("maintenanceFinishUmmaryService")
public class MaintenanceFinishUmmaryServiceImpl implements MaintenanceFinishUmmaryService {
    @Autowired
    private MaintenanceFinishUmmaryMapper maintenanceFinishUmmaryMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param ummmaryId 主键
     * @return 实例对象
     */
    @Override
    public MaintenanceFinishUmmary queryById(Integer ummmaryId) {
        return this.maintenanceFinishUmmaryMapper.queryById(ummmaryId);
    }

    /**
     * 分页查询
     *
     * @param maintenanceFinishUmmary 筛选条件
     * @param pageRequest             分页对象
     * @return 查询结果
     */
    @Override
    public Page<MaintenanceFinishUmmary> queryByPage(MaintenanceFinishUmmary maintenanceFinishUmmary, PageRequest pageRequest) {
        long total = this.maintenanceFinishUmmaryMapper.count(maintenanceFinishUmmary);
        return new PageImpl<>(this.maintenanceFinishUmmaryMapper.queryAllByLimit(maintenanceFinishUmmary, pageRequest), pageRequest, total);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    @Override
    public List<MaintenanceFinishUmmary> queryAll(String keyWord, int page, int num) {
        return this.maintenanceFinishUmmaryMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param maintenanceFinishUmmary 实例对象
     * @return 实例对象
     */
    @Override
    public MaintenanceFinishUmmary insert(MaintenanceFinishUmmary maintenanceFinishUmmary) {
        this.maintenanceFinishUmmaryMapper.insert(maintenanceFinishUmmary);
        return maintenanceFinishUmmary;
    }

    /**
     * 修改数据
     *
     * @param maintenanceFinishUmmary 实例对象
     * @return 实例对象
     */
    @Override
    public MaintenanceFinishUmmary update(MaintenanceFinishUmmary maintenanceFinishUmmary) {
        this.maintenanceFinishUmmaryMapper.update(maintenanceFinishUmmary);
        return this.queryById(maintenanceFinishUmmary.getUmmmaryId());
    }

    /**
     * 通过主键删除数据
     *
     * @param ummmaryId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer ummmaryId) {
        return this.maintenanceFinishUmmaryMapper.deleteById(ummmaryId) > 0;
    }
}
