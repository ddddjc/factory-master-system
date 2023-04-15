package com.djc.service;

import com.djc.entity.AccessoriesInboundDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 入库详情信息(AccessoriesInboundDetail)表服务接口
 *
 * @author djc
 * @since 2023-04-15 13:28:50
 */
public interface AccessoriesInboundDetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param inboundDetialId 主键
     * @return 实例对象
     */
    AccessoriesInboundDetail queryById(Integer inboundDetialId);

    /**
     * 分页查询
     *
     * @param accessoriesInboundDetail 筛选条件
     * @param pageRequest              分页对象
     * @return 查询结果
     */
    Page<AccessoriesInboundDetail> queryByPage(AccessoriesInboundDetail accessoriesInboundDetail, PageRequest pageRequest);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<AccessoriesInboundDetail> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param accessoriesInboundDetail 实例对象
     * @return 实例对象
     */
    AccessoriesInboundDetail insert(AccessoriesInboundDetail accessoriesInboundDetail);

    /**
     * 修改数据
     *
     * @param accessoriesInboundDetail 实例对象
     * @return 实例对象
     */
    AccessoriesInboundDetail update(AccessoriesInboundDetail accessoriesInboundDetail);

    /**
     * 通过主键删除数据
     *
     * @param inboundDetialId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer inboundDetialId);

}
