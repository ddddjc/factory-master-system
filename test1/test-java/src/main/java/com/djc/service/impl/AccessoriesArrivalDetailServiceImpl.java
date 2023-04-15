package com.djc.service.impl;

import com.djc.entity.AccessoriesArrivalDetail;
import com.djc.mapper.AccessoriesArrivalDetailMapper;
import com.djc.service.AccessoriesArrivalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 到货详情(AccessoriesArrivalDetail)表服务实现类
 *
 * @author djc
 * @since 2023-04-15 15:55:11
 */
@Service("accessoriesArrivalDetailService")
public class AccessoriesArrivalDetailServiceImpl implements AccessoriesArrivalDetailService {
    @Autowired
    private AccessoriesArrivalDetailMapper accessoriesArrivalDetailMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param arrivalDetailId 主键
     * @return 实例对象
     */
    @Override
    public AccessoriesArrivalDetail queryById(Integer arrivalDetailId) {
        return this.accessoriesArrivalDetailMapper.queryById(arrivalDetailId);
    }

    /**
     * 分页查询
     *
     * @param accessoriesArrivalDetail 筛选条件
     * @param pageRequest              分页对象
     * @return 查询结果
     */
    @Override
    public Page<AccessoriesArrivalDetail> queryByPage(AccessoriesArrivalDetail accessoriesArrivalDetail, PageRequest pageRequest) {
        long total = this.accessoriesArrivalDetailMapper.count(accessoriesArrivalDetail);
        return new PageImpl<>(this.accessoriesArrivalDetailMapper.queryAllByLimit(accessoriesArrivalDetail, pageRequest), pageRequest, total);
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
    public List<AccessoriesArrivalDetail> queryAll(String keyWord, int page, int num) {
        return this.accessoriesArrivalDetailMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param accessoriesArrivalDetail 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesArrivalDetail insert(AccessoriesArrivalDetail accessoriesArrivalDetail) {
        this.accessoriesArrivalDetailMapper.insert(accessoriesArrivalDetail);
        return accessoriesArrivalDetail;
    }

    /**
     * 修改数据
     *
     * @param accessoriesArrivalDetail 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesArrivalDetail update(AccessoriesArrivalDetail accessoriesArrivalDetail) {
        this.accessoriesArrivalDetailMapper.update(accessoriesArrivalDetail);
        return this.queryById(accessoriesArrivalDetail.getArrivalDetailId());
    }

    /**
     * 通过主键删除数据
     *
     * @param arrivalDetailId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer arrivalDetailId) {
        return this.accessoriesArrivalDetailMapper.deleteById(arrivalDetailId) > 0;
    }
}
