package com.djc.service.impl;

import com.djc.entity.AccessoriesOrder;
import com.djc.mapper.AccessoriesOrderMapper;
import com.djc.service.AccessoriesOrderService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 到货单(AccessoriesOrder)表服务实现类
 *
 * @author djc
 * @since 2023-05-18 15:17:25
 */
@Service("accessoriesOrderService")
public class AccessoriesOrderServiceImpl implements AccessoriesOrderService {
    @Resource
    private AccessoriesOrderMapper accessoriesOrderMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    @Override
    public AccessoriesOrder queryById(Integer orderId) {
        return this.accessoriesOrderMapper.queryById(orderId);
    }

    /**
     * 分页查询
     *
     * @param accessoriesOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<AccessoriesOrder> queryByPage(AccessoriesOrder accessoriesOrder, PageRequest pageRequest) {
        long total = this.accessoriesOrderMapper.count(accessoriesOrder);
        return new PageImpl<>(this.accessoriesOrderMapper.queryAllByLimit(accessoriesOrder, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param accessoriesOrder 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesOrder insert(AccessoriesOrder accessoriesOrder) {
        this.accessoriesOrderMapper.insert(accessoriesOrder);
        return accessoriesOrder;
    }

    /**
     * 修改数据
     *
     * @param accessoriesOrder 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesOrder update(AccessoriesOrder accessoriesOrder) {
        this.accessoriesOrderMapper.update(accessoriesOrder);
        return this.queryById(accessoriesOrder.getOrderId());
    }

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer orderId) {
        return this.accessoriesOrderMapper.deleteById(orderId) > 0;
    }

    /**
     * 模糊查询
     * @param accessoriesOrder
     * @param page
     * @param num
     * @return
     */
    @Override
    public List<AccessoriesOrder> queryByLike(AccessoriesOrder accessoriesOrder, Integer page, Integer num) {
        return accessoriesOrderMapper.queryByLikeLimit(accessoriesOrder,PageRequest.of(page,num));
    }

    @Override
    public Integer queryNumByLike(AccessoriesOrder accessoriesOrder) {
        return accessoriesOrderMapper.queryNumByLike(accessoriesOrder);
    }
}
