package com.djc.service;

import com.djc.entity.AccessoriesOutbound;

import java.util.List;

/**
 * 出库申请（领材料申请单）(AccessoriesOutbound)表服务接口
 *
 * @author djc
 * @since 2023-04-16 14:02:11
 */
public interface AccessoriesOutboundService {

    /**
     * 通过ID查询单条数据
     *
     * @param outboundId 主键
     * @return 实例对象
     */
    AccessoriesOutbound queryById(Integer outboundId);


    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<AccessoriesOutbound> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param accessoriesOutbound 实例对象
     * @return 实例对象
     */
    AccessoriesOutbound insert(AccessoriesOutbound accessoriesOutbound);

    /**
     * 修改数据
     *
     * @param accessoriesOutbound 实例对象
     * @return 实例对象
     */
    AccessoriesOutbound update(AccessoriesOutbound accessoriesOutbound);

    /**
     * 通过主键删除数据
     *
     * @param outboundId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer outboundId);

    /**
     * 模糊查询
     * @param accessoriesOutbound
     * @param page
     * @param num
     * @return
     */
    List<AccessoriesOutbound> queryByLike(AccessoriesOutbound accessoriesOutbound, Integer page, Integer num);

    Integer likeNum(AccessoriesOutbound accessoriesOutbound);
}
