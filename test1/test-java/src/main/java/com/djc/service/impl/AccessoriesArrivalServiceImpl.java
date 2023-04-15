package com.djc.service.impl;

import com.djc.entity.AccessoriesArrival;
import com.djc.mapper.AccessoriesArrivalMapper;
import com.djc.service.AccessoriesArrivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 到货单(AccessoriesArrival)表服务实现类
 *
 * @author djc
 * @since 2023-04-15 13:28:55
 */
@Service("accessoriesArrivalService")
public class AccessoriesArrivalServiceImpl implements AccessoriesArrivalService {
    @Autowired
    private AccessoriesArrivalMapper accessoriesArrivalMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param arrivalId 主键
     * @return 实例对象
     */
    @Override
    public AccessoriesArrival queryById(Integer arrivalId) {
        return this.accessoriesArrivalMapper.queryById(arrivalId);
    }

    /**
     * 分页查询
     *
     * @param accessoriesArrival 筛选条件
     * @param pageRequest        分页对象
     * @return 查询结果
     */
    @Override
    public Page<AccessoriesArrival> queryByPage(AccessoriesArrival accessoriesArrival, PageRequest pageRequest) {
        long total = this.accessoriesArrivalMapper.count(accessoriesArrival);
        return new PageImpl<>(this.accessoriesArrivalMapper.queryAllByLimit(accessoriesArrival, pageRequest), pageRequest, total);
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
    public List<AccessoriesArrival> queryAll(String keyWord, int page, int num) {
        return this.accessoriesArrivalMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param accessoriesArrival 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesArrival insert(AccessoriesArrival accessoriesArrival) {
        this.accessoriesArrivalMapper.insert(accessoriesArrival);
        return accessoriesArrival;
    }

    /**
     * 修改数据
     *
     * @param accessoriesArrival 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesArrival update(AccessoriesArrival accessoriesArrival) {
        this.accessoriesArrivalMapper.update(accessoriesArrival);
        return this.queryById(accessoriesArrival.getArrivalId());
    }

    /**
     * 通过主键删除数据
     *
     * @param arrivalId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer arrivalId) {
        return this.accessoriesArrivalMapper.deleteById(arrivalId) > 0;
    }
}
