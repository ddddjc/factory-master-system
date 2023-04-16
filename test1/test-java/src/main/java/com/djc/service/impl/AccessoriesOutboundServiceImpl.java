package com.djc.service.impl;

import com.djc.entity.AccessoriesOutbound;
import com.djc.mapper.AccessoriesOutboundMapper;
import com.djc.service.AccessoriesOutboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 出库申请（领材料申请单）(AccessoriesOutbound)表服务实现类
 *
 * @author djc
 * @since 2023-04-16 14:02:11
 */
@Service("accessoriesOutboundService")
public class AccessoriesOutboundServiceImpl implements AccessoriesOutboundService {
    @Autowired
    private AccessoriesOutboundMapper accessoriesOutboundMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param outboundId 主键
     * @return 实例对象
     */
    @Override
    public AccessoriesOutbound queryById(Integer outboundId) {
        return this.accessoriesOutboundMapper.queryById(outboundId);
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
    public List<AccessoriesOutbound> queryAll(String keyWord, int page, int num) {
        return this.accessoriesOutboundMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param accessoriesOutbound 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesOutbound insert(AccessoriesOutbound accessoriesOutbound) {
        this.accessoriesOutboundMapper.insert(accessoriesOutbound);
        return accessoriesOutbound;
    }

    /**
     * 修改数据
     *
     * @param accessoriesOutbound 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesOutbound update(AccessoriesOutbound accessoriesOutbound) {
        this.accessoriesOutboundMapper.update(accessoriesOutbound);
        return this.queryById(accessoriesOutbound.getOutboundId());
    }

    /**
     * 通过主键删除数据
     *
     * @param outboundId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer outboundId) {
        return this.accessoriesOutboundMapper.deleteById(outboundId) > 0;
    }
}
