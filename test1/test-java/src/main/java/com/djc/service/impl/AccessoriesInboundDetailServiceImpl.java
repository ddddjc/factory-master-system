package com.djc.service.impl;

import com.djc.entity.AccessoriesInboundDetail;
import com.djc.mapper.AccessoriesInboundDetailMapper;
import com.djc.service.AccessoriesInboundDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 入库详情信息(AccessoriesInboundDetail)表服务实现类
 *
 * @author djc
 * @since 2023-04-15 15:28:59
 */
@Service("accessoriesInboundDetailService")
public class AccessoriesInboundDetailServiceImpl implements AccessoriesInboundDetailService {
    @Autowired
    private AccessoriesInboundDetailMapper accessoriesInboundDetailMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param inboundDetialId 主键
     * @return 实例对象
     */
    @Override
    public AccessoriesInboundDetail queryById(Integer inboundDetialId) {
        return this.accessoriesInboundDetailMapper.queryById(inboundDetialId);
    }

    /**
     * 分页查询
     *
     * @param accessoriesInboundDetail 筛选条件
     * @param pageRequest              分页对象
     * @return 查询结果
     */
    @Override
    public Page<AccessoriesInboundDetail> queryByPage(AccessoriesInboundDetail accessoriesInboundDetail, PageRequest pageRequest) {
        long total = this.accessoriesInboundDetailMapper.count(accessoriesInboundDetail);
        return new PageImpl<>(this.accessoriesInboundDetailMapper.queryAllByLimit(accessoriesInboundDetail, pageRequest), pageRequest, total);
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
    public List<AccessoriesInboundDetail> queryAll(String keyWord, int page, int num) {
        return this.accessoriesInboundDetailMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param accessoriesInboundDetail 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesInboundDetail insert(AccessoriesInboundDetail accessoriesInboundDetail) {
        this.accessoriesInboundDetailMapper.insert(accessoriesInboundDetail);
        return accessoriesInboundDetail;
    }

    /**
     * 修改数据
     *
     * @param accessoriesInboundDetail 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesInboundDetail update(AccessoriesInboundDetail accessoriesInboundDetail) {
        this.accessoriesInboundDetailMapper.update(accessoriesInboundDetail);
        return this.queryById(accessoriesInboundDetail.getInboundDetialId());
    }

    /**
     * 通过主键删除数据
     *
     * @param inboundDetialId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer inboundDetialId) {
        return this.accessoriesInboundDetailMapper.deleteById(inboundDetialId) > 0;
    }
}
