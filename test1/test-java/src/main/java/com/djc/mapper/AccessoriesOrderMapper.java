package com.djc.mapper;

import com.djc.entity.AccessoriesOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 到货单(AccessoriesOrder)表数据库访问层
 *
 * @author djc
 * @since 2023-05-18 15:17:24
 */
public interface AccessoriesOrderMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    AccessoriesOrder queryById(Integer orderId);

    /**
     * 查询指定行数据
     *
     * @param accessoriesOrder 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<AccessoriesOrder> queryAllByLimit(@Param("accessoriesOrder") AccessoriesOrder accessoriesOrder, @Param("pageable") Pageable pageable);

    List<AccessoriesOrder> queryByLikeLimit(@Param("accessoriesOrder") AccessoriesOrder accessoriesOrder, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param accessoriesOrder 查询条件
     * @return 总行数
     */
    long count(AccessoriesOrder accessoriesOrder);

    /**
     * 新增数据
     *
     * @param accessoriesOrder 实例对象
     * @return 影响行数
     */
    int insert(AccessoriesOrder accessoriesOrder);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AccessoriesOrder> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AccessoriesOrder> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AccessoriesOrder> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<AccessoriesOrder> entities);

    /**
     * 修改数据
     *
     * @param accessoriesOrder 实例对象
     * @return 影响行数
     */
    int update(AccessoriesOrder accessoriesOrder);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 影响行数
     */
    int deleteById(Integer orderId);

    Integer queryNumByLike(@Param("accessoriesOrder") AccessoriesOrder accessoriesOrder);
}

