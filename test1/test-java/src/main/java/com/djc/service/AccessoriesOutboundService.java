package com.djc.service;

import com.djc.entity.AccessoriesOutbound;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 出库申请（领材料申请单）(AccessoriesOutbound)表服务接口
 *
 * @author djc
 * @since 2023-04-15 15:55:05
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
     * 分页查询
     *
     * @param accessoriesOutbound 筛选条件
     * @param pageRequest         分页对象
     * @return 查询结果
     */
    Page<AccessoriesOutbound> queryByPage(AccessoriesOutbound accessoriesOutbound, PageRequest pageRequest);

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

}
