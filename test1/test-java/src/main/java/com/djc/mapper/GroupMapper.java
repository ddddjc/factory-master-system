package com.djc.mapper;

import com.djc.entity.Employee;
import com.djc.entity.Group;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 小组表(Group)表数据库访问层
 *
 * @author djc
 * @since 2023-03-19 19:14:21
 */
public interface GroupMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param groupId 主键
     * @return 实例对象
     */
    Group queryById(Integer groupId);

    /**
     * 查询指定行数据
     *
     * @param group    查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Group> queryAllByLimit(Group group, @Param("pageable") Pageable pageable);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<Group> queryAll(String keyWord, int page, int num);

    /**
     * 通过小组id查询成员
     * @param groupId 小组id
     * @return 多条数据
     */
    List<Employee> findEmployee(Integer groupId);

    /**
     * 统计总行数
     *
     * @param group 查询条件
     * @return 总行数
     */
    long count(Group group);

    /**
     * 新增数据
     *
     * @param group 实例对象
     * @return 影响行数
     */
    int insert(Group group);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Group> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Group> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Group> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Group> entities);

    /**
     * 修改数据
     *
     * @param group 实例对象
     * @return 影响行数
     */
    int update(Group group);

    /**
     * 通过主键删除数据
     *
     * @param groupId 主键
     * @return 影响行数
     */
    int deleteById(Integer groupId);

    void deleteEmployee(@Param("groupId") Integer groupId,@Param("employeeId") Integer employeeId);
}

