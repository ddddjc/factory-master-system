package com.djc.mapper;

import com.djc.entity.Team;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 小组表(Team)表数据库访问层
 *
 * @author djc
 * @since 2023-04-16 14:02:07
 */
public interface TeamMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param teamId 主键
     * @return 实例对象
     */
    Team queryById(Integer teamId);

    /**
     * 查询指定行数据
     *
     * @param team     查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Team> queryAllByLimit(Team team, @Param("pageable") Pageable pageable);

    /**
     * 模糊查询
     * @param team
     * @param pageable
     * @return
     */
    List<Team> queryAllByLike(Team team, @Param("pageable") Pageable pageable);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<Team> queryAll(@Param("keyWord") String keyWord, @Param("page") int page, @Param("num") int num);

    /**
     * 统计总行数
     *
     * @param team 查询条件
     * @return 总行数
     */
    long count(Team team);

    /**
     * 新增数据
     *
     * @param team 实例对象
     * @return 影响行数
     */
    int insert(Team team);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Team> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Team> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Team> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Team> entities);

    /**
     * 修改数据
     *
     * @param team 实例对象
     * @return 影响行数
     */
    int update(Team team);

    /**
     * 通过主键删除数据
     *
     * @param teamId 主键
     * @return 影响行数
     */
    int deleteById(Integer teamId);

}

