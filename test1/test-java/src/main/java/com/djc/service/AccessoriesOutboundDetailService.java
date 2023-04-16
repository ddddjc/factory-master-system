package com.djc.service;

import com.djc.entity.AccessoriesOutboundDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 出库详情（材料申请表）(AccessoriesOutboundDetail)表服务接口
 *
 * @author djc
 * @since 2023-04-16 14:02:07
 */
public interface AccessoriesOutboundDetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param outboundDetailId 主键
     * @return 实例对象
     */
    AccessoriesOutboundDetail queryById(Integer outboundDetailId);


    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<AccessoriesOutboundDetail> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param accessoriesOutboundDetail 实例对象
     * @return 实例对象
     */
    AccessoriesOutboundDetail insert(AccessoriesOutboundDetail accessoriesOutboundDetail);

    /**
     * 修改数据
     *
     * @param accessoriesOutboundDetail 实例对象
     * @return 实例对象
     */
    AccessoriesOutboundDetail update(AccessoriesOutboundDetail accessoriesOutboundDetail);

    /**
     * 通过主键删除数据
     *
     * @param outboundDetailId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer outboundDetailId);

}
