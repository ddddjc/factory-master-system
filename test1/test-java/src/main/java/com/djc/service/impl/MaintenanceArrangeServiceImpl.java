package com.djc.service.impl;

import com.djc.entity.MaintenanceArrange;
import com.djc.mapper.MaintenanceArrangeMapper;
import com.djc.service.MaintenanceArrangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 维护（保养）安排表(MaintenanceArrange)表服务实现类
 *
 * @author djc
 * @since 2023-04-15 15:28:51
 */
@Service("maintenanceArrangeService")
public class MaintenanceArrangeServiceImpl implements MaintenanceArrangeService {
    @Autowired
    private MaintenanceArrangeMapper maintenanceArrangeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param maintenanceArrangeId 主键
     * @return 实例对象
     */
    @Override
    public MaintenanceArrange queryById(Integer maintenanceArrangeId) {
        return this.maintenanceArrangeMapper.queryById(maintenanceArrangeId);
    }

    /**
     * 分页查询
     *
     * @param maintenanceArrange 筛选条件
     * @param pageRequest        分页对象
     * @return 查询结果
     */
    @Override
    public Page<MaintenanceArrange> queryByPage(MaintenanceArrange maintenanceArrange, PageRequest pageRequest) {
        long total = this.maintenanceArrangeMapper.count(maintenanceArrange);
        return new PageImpl<>(this.maintenanceArrangeMapper.queryAllByLimit(maintenanceArrange, pageRequest), pageRequest, total);
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
    public List<MaintenanceArrange> queryAll(String keyWord, int page, int num) {
        return this.maintenanceArrangeMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param maintenanceArrange 实例对象
     * @return 实例对象
     */
    @Override
    public MaintenanceArrange insert(MaintenanceArrange maintenanceArrange) {
        this.maintenanceArrangeMapper.insert(maintenanceArrange);
        return maintenanceArrange;
    }

    /**
     * 修改数据
     *
     * @param maintenanceArrange 实例对象
     * @return 实例对象
     */
    @Override
    public MaintenanceArrange update(MaintenanceArrange maintenanceArrange) {
        this.maintenanceArrangeMapper.update(maintenanceArrange);
        return this.queryById(maintenanceArrange.getMaintenanceArrangeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param maintenanceArrangeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer maintenanceArrangeId) {
        return this.maintenanceArrangeMapper.deleteById(maintenanceArrangeId) > 0;
    }
}
