package com.djc.service.impl;

import com.djc.entity.AccessoriesProcurementDetail;
import com.djc.mapper.AccessoriesProcurementDetailMapper;
import com.djc.service.AccessoriesProcurementDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 申购详情(AccessoriesProcurementDetail)表服务实现类
 *
 * @author djc
 * @since 2023-04-16 14:02:08
 */
@Service("accessoriesProcurementDetailService")
public class AccessoriesProcurementDetailServiceImpl implements AccessoriesProcurementDetailService {
    @Autowired
    private AccessoriesProcurementDetailMapper accessoriesProcurementDetailMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param procurementDetailId 主键
     * @return 实例对象
     */
    @Override
    public AccessoriesProcurementDetail queryById(Integer procurementDetailId) {
        return this.accessoriesProcurementDetailMapper.queryById(procurementDetailId);
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
    public List<AccessoriesProcurementDetail> queryAll(String keyWord, int page, int num) {
        return this.accessoriesProcurementDetailMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param accessoriesProcurementDetail 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesProcurementDetail insert(AccessoriesProcurementDetail accessoriesProcurementDetail) {
        this.accessoriesProcurementDetailMapper.insert(accessoriesProcurementDetail);
        return accessoriesProcurementDetail;
    }

    /**
     * 修改数据
     *
     * @param accessoriesProcurementDetail 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesProcurementDetail update(AccessoriesProcurementDetail accessoriesProcurementDetail) {
        this.accessoriesProcurementDetailMapper.update(accessoriesProcurementDetail);
        return this.queryById(accessoriesProcurementDetail.getProcurementDetailId());
    }

    /**
     * 通过主键删除数据
     *
     * @param procurementDetailId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer procurementDetailId) {
        return this.accessoriesProcurementDetailMapper.deleteById(procurementDetailId) > 0;
    }
}
