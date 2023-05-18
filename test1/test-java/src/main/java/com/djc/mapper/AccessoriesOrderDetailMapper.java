package com.djc.mapper;

import com.djc.entity.AccessoriesOrderDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 到货详情(AccessoriesOrderDetail)表数据库访问层
 *
 * @author djc
 * @since 2023-05-18 15:17:25
 */
public interface AccessoriesOrderDetailMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param orderDetailId 主键
     * @return 实例对象
     */
    AccessoriesOrderDetail queryById(Integer orderDetailId);

    /**
     * 查询指定行数据
     *
     * @param accessoriesOrderDetail 查询条件
     * @param pageable               分页对象
     * @return 对象列表
     */
    List<AccessoriesOrderDetail> queryAllByLimit(@Param("accessoriesOrderDetail") AccessoriesOrderDetail accessoriesOrderDetail, @Param("pageable") Pageable pageable);

    /**
     * 模糊查询
     * @param accessoriesOrderDetail
     * @param pageable
     * @return
     */
    List<AccessoriesOrderDetail> queryByLimit(@Param("accessoriesOrderDetail") AccessoriesOrderDetail accessoriesOrderDetail, @Param("pageable") Pageable pageable);
    /**
     * 统计总行数
     *
     * @param accessoriesOrderDetail 查询条件
     * @return 总行数
     */
    long count(AccessoriesOrderDetail accessoriesOrderDetail);

    /**
     * 新增数据
     *
     * @param accessoriesOrderDetail 实例对象
     * @return 影响行数
     */
    int insert(AccessoriesOrderDetail accessoriesOrderDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AccessoriesOrderDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AccessoriesOrderDetail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AccessoriesOrderDetail> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<AccessoriesOrderDetail> entities);

    /**
     * 修改数据
     *
     * @param accessoriesOrderDetail 实例对象
     * @return 影响行数
     */
    int update(AccessoriesOrderDetail accessoriesOrderDetail);

    /**
     * 通过主键删除数据
     *
     * @param orderDetailId 主键
     * @return 影响行数
     */
    int deleteById(Integer orderDetailId);

    /**
     * 模糊查询数量
     * @param accessoriesOrderDetail
     * @return
     */
    Integer queryNumByLike(@Param("accessoriesOrderDetail") AccessoriesOrderDetail accessoriesOrderDetail);

}

