package com.djc.service.impl;

import com.djc.entity.MaintenanceRecords;
import com.djc.mapper.MaintenanceRecordsMapper;
import com.djc.service.MaintenanceRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 维修记录表
 * (MaintenanceRecords)表服务实现类
 *
 * @author djc
 * @since 2023-03-21 21:59:30
 */
@Service("maintenanceRecordsService")
public class MaintenanceRecordsServiceImpl implements MaintenanceRecordsService {
    @Autowired
    private MaintenanceRecordsMapper maintenanceRecordsMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param recordsId 主键
     * @return 实例对象
     */
    @Override
    public MaintenanceRecords queryById(Integer recordsId) {
        return this.maintenanceRecordsMapper.queryById(recordsId);
    }

    /**
     * 分页查询
     *
     * @param maintenanceRecords 筛选条件
     * @param pageRequest        分页对象
     * @return 查询结果
     */
    @Override
    public Page<MaintenanceRecords> queryByPage(MaintenanceRecords maintenanceRecords, PageRequest pageRequest) {
        long total = this.maintenanceRecordsMapper.count(maintenanceRecords);
        return new PageImpl<>(this.maintenanceRecordsMapper.queryAllByLimit(maintenanceRecords, pageRequest), pageRequest, total);
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
    public List<MaintenanceRecords> queryAll(String keyWord, int page, int num) {
        return this.maintenanceRecordsMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param maintenanceRecords 实例对象
     * @return 实例对象
     */
    @Override
    public MaintenanceRecords insert(MaintenanceRecords maintenanceRecords) {
        this.maintenanceRecordsMapper.insert(maintenanceRecords);
        return maintenanceRecords;
    }

    /**
     * 修改数据
     *
     * @param maintenanceRecords 实例对象
     * @return 实例对象
     */
    @Override
    public MaintenanceRecords update(MaintenanceRecords maintenanceRecords) {
        this.maintenanceRecordsMapper.update(maintenanceRecords);
        return this.queryById(maintenanceRecords.getRecordsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param recordsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer recordsId) {
        return this.maintenanceRecordsMapper.deleteById(recordsId) > 0;
    }
}
