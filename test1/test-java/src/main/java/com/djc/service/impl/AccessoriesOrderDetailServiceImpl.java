package com.djc.service.impl;

import com.djc.entity.AccessoriesOrder;
import com.djc.entity.AccessoriesOrderDetail;
import com.djc.mapper.AccessoriesOrderDetailMapper;
import com.djc.service.AccessoriesOrderDetailService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 到货详情(AccessoriesOrderDetail)表服务实现类
 *
 * @author djc
 * @since 2023-05-18 15:17:26
 */
@Service("accessoriesOrderDetailService")
public class AccessoriesOrderDetailServiceImpl implements AccessoriesOrderDetailService {
    @Resource
    private AccessoriesOrderDetailMapper accessoriesOrderDetailMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param orderDetailId 主键
     * @return 实例对象
     */
    @Override
    public AccessoriesOrderDetail queryById(Integer orderDetailId) {
        return this.accessoriesOrderDetailMapper.queryById(orderDetailId);
    }

    /**
     * 分页查询
     *
     * @param accessoriesOrderDetail 筛选条件
     * @param pageRequest            分页对象
     * @return 查询结果
     */
    @Override
    public Page<AccessoriesOrderDetail> queryByPage(AccessoriesOrderDetail accessoriesOrderDetail, PageRequest pageRequest) {
        long total = this.accessoriesOrderDetailMapper.count(accessoriesOrderDetail);
        return new PageImpl<>(this.accessoriesOrderDetailMapper.queryAllByLimit(accessoriesOrderDetail, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param accessoriesOrderDetail 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesOrderDetail insert(AccessoriesOrderDetail accessoriesOrderDetail) {
        this.accessoriesOrderDetailMapper.insert(accessoriesOrderDetail);
        return accessoriesOrderDetail;
    }

    /**
     * 修改数据
     *
     * @param accessoriesOrderDetail 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesOrderDetail update(AccessoriesOrderDetail accessoriesOrderDetail) {
        this.accessoriesOrderDetailMapper.update(accessoriesOrderDetail);
        return this.queryById(accessoriesOrderDetail.getOrderDetailId());
    }

    /**
     * 通过主键删除数据
     *
     * @param orderDetailId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer orderDetailId) {
        return this.accessoriesOrderDetailMapper.deleteById(orderDetailId) > 0;
    }

    /**
     * 模糊查询
     * @param accessoriesOrderDetail
     * @param page
     * @param num
     * @return
     */
    @Override
    public List<AccessoriesOrderDetail> queryByLike(AccessoriesOrderDetail accessoriesOrderDetail, Integer page, Integer num) {
        return accessoriesOrderDetailMapper.queryByLimit(accessoriesOrderDetail,PageRequest.of(page,num));
    }

    /**
     * 模糊查询数量
     * @param accessoriesOrderDetail
     * @return
     */
    @Override
    public Integer queryNumByLike(AccessoriesOrderDetail accessoriesOrderDetail) {
        return accessoriesOrderDetailMapper.queryNumByLike(accessoriesOrderDetail);
    }
}
