package com.djc.service.impl;

import com.djc.entity.AccessoriesInbound;
import com.djc.mapper.AccessoriesInboundMapper;
import com.djc.service.AccessoriesInboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 入库信息(AccessoriesInbound)表服务实现类
 *
 * @author djc
 * @since 2023-04-15 15:29:00
 */
@Service("accessoriesInboundService")
public class AccessoriesInboundServiceImpl implements AccessoriesInboundService {
    @Autowired
    private AccessoriesInboundMapper accessoriesInboundMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param inboundId 主键
     * @return 实例对象
     */
    @Override
    public AccessoriesInbound queryById(Integer inboundId) {
        return this.accessoriesInboundMapper.queryById(inboundId);
    }

    /**
     * 分页查询
     *
     * @param accessoriesInbound 筛选条件
     * @param pageRequest        分页对象
     * @return 查询结果
     */
    @Override
    public Page<AccessoriesInbound> queryByPage(AccessoriesInbound accessoriesInbound, PageRequest pageRequest) {
        long total = this.accessoriesInboundMapper.count(accessoriesInbound);
        return new PageImpl<>(this.accessoriesInboundMapper.queryAllByLimit(accessoriesInbound, pageRequest), pageRequest, total);
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
    public List<AccessoriesInbound> queryAll(String keyWord, int page, int num) {
        return this.accessoriesInboundMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param accessoriesInbound 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesInbound insert(AccessoriesInbound accessoriesInbound) {
        this.accessoriesInboundMapper.insert(accessoriesInbound);
        return accessoriesInbound;
    }

    /**
     * 修改数据
     *
     * @param accessoriesInbound 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesInbound update(AccessoriesInbound accessoriesInbound) {
        this.accessoriesInboundMapper.update(accessoriesInbound);
        return this.queryById(accessoriesInbound.getInboundId());
    }

    /**
     * 通过主键删除数据
     *
     * @param inboundId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer inboundId) {
        return this.accessoriesInboundMapper.deleteById(inboundId) > 0;
    }
}
