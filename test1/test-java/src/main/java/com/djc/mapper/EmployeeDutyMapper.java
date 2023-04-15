package com.djc.mapper;

import com.djc.entity.EmployeeDuty;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 小组值班分工(EmployeeDuty)表数据库访问层
 *
 * @author djc
 * @since 2023-04-15 15:29:01
 */
public interface EmployeeDutyMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param dutyId 主键
     * @return 实例对象
     */
    EmployeeDuty queryById(Integer dutyId);

    /**
     * 查询指定行数据
     *
     * @param employeeDuty 查询条件
     * @param pageable     分页对象
     * @return 对象列表
     */
    List<EmployeeDuty> queryAllByLimit(EmployeeDuty employeeDuty, @Param("pageable") Pageable pageable);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<EmployeeDuty> queryAll(@Param("keyWord") String keyWord, @Param("page") int page, @Param("num") int num);

    /**
     * 统计总行数
     *
     * @param employeeDuty 查询条件
     * @return 总行数
     */
    long count(EmployeeDuty employeeDuty);

    /**
     * 新增数据
     *
     * @param employeeDuty 实例对象
     * @return 影响行数
     */
    int insert(EmployeeDuty employeeDuty);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeDuty> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EmployeeDuty> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeDuty> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<EmployeeDuty> entities);

    /**
     * 修改数据
     *
     * @param employeeDuty 实例对象
     * @return 影响行数
     */
    int update(EmployeeDuty employeeDuty);

    /**
     * 通过主键删除数据
     *
     * @param dutyId 主键
     * @return 影响行数
     */
    int deleteById(Integer dutyId);

}

