package com.djc.service;

import com.djc.entity.AccessoriesInbound;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 入库信息(AccessoriesInbound)表服务接口
 *
 * @author djc
 * @since 2023-04-15 15:55:06
 */
public interface AccessoriesInboundService {

    /**
     * 通过ID查询单条数据
     *
     * @param inboundId 主键
     * @return 实例对象
     */
    AccessoriesInbound queryById(Integer inboundId);

    /**
     * 分页查询
     *
     * @param accessoriesInbound 筛选条件
     * @param pageRequest        分页对象
     * @return 查询结果
     */
    Page<AccessoriesInbound> queryByPage(AccessoriesInbound accessoriesInbound, PageRequest pageRequest);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<AccessoriesInbound> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param accessoriesInbound 实例对象
     * @return 实例对象
     */
    AccessoriesInbound insert(AccessoriesInbound accessoriesInbound);

    /**
     * 修改数据
     *
     * @param accessoriesInbound 实例对象
     * @return 实例对象
     */
    AccessoriesInbound update(AccessoriesInbound accessoriesInbound);

    /**
     * 通过主键删除数据
     *
     * @param inboundId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer inboundId);

}
