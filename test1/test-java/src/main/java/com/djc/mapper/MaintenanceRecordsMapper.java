package com.djc.mapper;

import com.djc.entity.MaintenanceRecords;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 维修记录表
 * (MaintenanceRecords)表数据库访问层
 *
 * @author djc
 * @since 2023-03-21 21:59:30
 */
public interface MaintenanceRecordsMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param recordsId 主键
     * @return 实例对象
     */
    MaintenanceRecords queryById(Integer recordsId);

    /**
     * 查询指定行数据
     *
     * @param maintenanceRecords 查询条件
     * @param pageable           分页对象
     * @return 对象列表
     */
    List<MaintenanceRecords> queryAllByLimit(MaintenanceRecords maintenanceRecords, @Param("pageable") Pageable pageable);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<MaintenanceRecords> queryAll(@Param("keyWord") String keyWord, @Param("page") int page,@Param("num") int num);

    /**
     * 统计总行数
     *
     * @param maintenanceRecords 查询条件
     * @return 总行数
     */
    long count(MaintenanceRecords maintenanceRecords);

    /**
     * 新增数据
     *
     * @param maintenanceRecords 实例对象
     * @return 影响行数
     */
    int insert(MaintenanceRecords maintenanceRecords);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MaintenanceRecords> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MaintenanceRecords> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MaintenanceRecords> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MaintenanceRecords> entities);

    /**
     * 修改数据
     *
     * @param maintenanceRecords 实例对象
     * @return 影响行数
     */
    int update(MaintenanceRecords maintenanceRecords);

    /**
     * 通过主键删除数据
     *
     * @param recordsId 主键
     * @return 影响行数
     */
    int deleteById(Integer recordsId);

    List<MaintenanceRecords> queryByMachineId(@Param("machineId") Integer machineId);

    List<MaintenanceRecords> queryByEmployeeName(@Param("name") String name, @Param("page") int i, @Param("num") Integer num);
}

