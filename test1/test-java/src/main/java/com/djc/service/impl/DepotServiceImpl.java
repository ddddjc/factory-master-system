package com.djc.service.impl;

import com.djc.entity.Depot;
import com.djc.mapper.DepotMapper;
import com.djc.service.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 仓库信息
 * (Depot)表服务实现类
 *
 * @author djc
 * @since 2023-04-15 15:55:14
 */
@Service("depotService")
public class DepotServiceImpl implements DepotService {
    @Autowired
    private DepotMapper depotMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param depotId 主键
     * @return 实例对象
     */
    @Override
    public Depot queryById(Integer depotId) {
        return this.depotMapper.queryById(depotId);
    }

    /**
     * 分页查询
     *
     * @param depot       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Depot> queryByPage(Depot depot, PageRequest pageRequest) {
        long total = this.depotMapper.count(depot);
        return new PageImpl<>(this.depotMapper.queryAllByLimit(depot, pageRequest), pageRequest, total);
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
    public List<Depot> queryAll(String keyWord, int page, int num) {
        return this.depotMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param depot 实例对象
     * @return 实例对象
     */
    @Override
    public Depot insert(Depot depot) {
        this.depotMapper.insert(depot);
        return depot;
    }

    /**
     * 修改数据
     *
     * @param depot 实例对象
     * @return 实例对象
     */
    @Override
    public Depot update(Depot depot) {
        this.depotMapper.update(depot);
        return this.queryById(depot.getDepotId());
    }

    /**
     * 通过主键删除数据
     *
     * @param depotId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer depotId) {
        return this.depotMapper.deleteById(depotId) > 0;
    }
}
