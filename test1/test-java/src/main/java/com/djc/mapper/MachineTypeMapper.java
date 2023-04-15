package com.djc.mapper;

import com.djc.entity.MachineType;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 机器类型(按种类）
 * (MachineType)表数据库访问层
 *
 * @author djc
 * @since 2023-04-15 15:28:52
 */
public interface MachineTypeMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param machineTypeId 主键
     * @return 实例对象
     */
    MachineType queryById(Integer machineTypeId);

    /**
     * 查询指定行数据
     *
     * @param machineType 查询条件
     * @param pageable    分页对象
     * @return 对象列表
     */
    List<MachineType> queryAllByLimit(MachineType machineType, @Param("pageable") Pageable pageable);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<MachineType> queryAll(@Param("keyWord") String keyWord, @Param("page") int page, @Param("num") int num);

    /**
     * 统计总行数
     *
     * @param machineType 查询条件
     * @return 总行数
     */
    long count(MachineType machineType);

    /**
     * 新增数据
     *
     * @param machineType 实例对象
     * @return 影响行数
     */
    int insert(MachineType machineType);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MachineType> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MachineType> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MachineType> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MachineType> entities);

    /**
     * 修改数据
     *
     * @param machineType 实例对象
     * @return 影响行数
     */
    int update(MachineType machineType);

    /**
     * 通过主键删除数据
     *
     * @param machineTypeId 主键
     * @return 影响行数
     */
    int deleteById(Integer machineTypeId);

}

