package com.djc.service.impl;

import com.djc.entity.AccessoriesOutboundDetail;
import com.djc.mapper.AccessoriesOutboundDetailMapper;
import com.djc.service.AccessoriesOutboundDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 出库详情（材料申请表）(AccessoriesOutboundDetail)表服务实现类
 *
 * @author djc
 * @since 2023-04-15 15:29:02
 */
@Service("accessoriesOutboundDetailService")
public class AccessoriesOutboundDetailServiceImpl implements AccessoriesOutboundDetailService {
    @Autowired
    private AccessoriesOutboundDetailMapper accessoriesOutboundDetailMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param outboundDetailId 主键
     * @return 实例对象
     */
    @Override
    public AccessoriesOutboundDetail queryById(Integer outboundDetailId) {
        return this.accessoriesOutboundDetailMapper.queryById(outboundDetailId);
    }

    /**
     * 分页查询
     *
     * @param accessoriesOutboundDetail 筛选条件
     * @param pageRequest               分页对象
     * @return 查询结果
     */
    @Override
    public Page<AccessoriesOutboundDetail> queryByPage(AccessoriesOutboundDetail accessoriesOutboundDetail, PageRequest pageRequest) {
        long total = this.accessoriesOutboundDetailMapper.count(accessoriesOutboundDetail);
        return new PageImpl<>(this.accessoriesOutboundDetailMapper.queryAllByLimit(accessoriesOutboundDetail, pageRequest), pageRequest, total);
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
    public List<AccessoriesOutboundDetail> queryAll(String keyWord, int page, int num) {
        return this.accessoriesOutboundDetailMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param accessoriesOutboundDetail 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesOutboundDetail insert(AccessoriesOutboundDetail accessoriesOutboundDetail) {
        this.accessoriesOutboundDetailMapper.insert(accessoriesOutboundDetail);
        return accessoriesOutboundDetail;
    }

    /**
     * 修改数据
     *
     * @param accessoriesOutboundDetail 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesOutboundDetail update(AccessoriesOutboundDetail accessoriesOutboundDetail) {
        this.accessoriesOutboundDetailMapper.update(accessoriesOutboundDetail);
        return this.queryById(accessoriesOutboundDetail.getOutboundDetailId());
    }

    /**
     * 通过主键删除数据
     *
     * @param outboundDetailId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer outboundDetailId) {
        return this.accessoriesOutboundDetailMapper.deleteById(outboundDetailId) > 0;
    }
}
