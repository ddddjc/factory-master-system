package com.djc.mapper;

import com.djc.entity.EmployeeMachine;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (EmployeeMachine)表数据库访问层
 *
 * @author djc
 * @since 2023-03-19 19:14:20
 */
public interface EmployeeMachineMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    EmployeeMachine queryById(Integer employeeId);

    /**
     * 查询指定行数据
     *
     * @param employeeMachine 查询条件
     * @param pageable        分页对象
     * @return 对象列表
     */
    List<EmployeeMachine> queryAllByLimit(EmployeeMachine employeeMachine, @Param("pageable") Pageable pageable);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<EmployeeMachine> queryAll(String keyWord, int page, int num);

    /**
     * 统计总行数
     *
     * @param employeeMachine 查询条件
     * @return 总行数
     */
    long count(EmployeeMachine employeeMachine);

    /**
     * 新增数据
     *
     * @param employeeMachine 实例对象
     * @return 影响行数
     */
    int insert(EmployeeMachine employeeMachine);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeMachine> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EmployeeMachine> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeMachine> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<EmployeeMachine> entities);

    /**
     * 修改数据
     *
     * @param employeeMachine 实例对象
     * @return 影响行数
     */
    int update(EmployeeMachine employeeMachine);

    /**
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 影响行数
     */
    int deleteById(Integer employeeId);

}

