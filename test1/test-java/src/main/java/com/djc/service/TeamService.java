package com.djc.service;

import com.djc.entity.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 小组表(Team)表服务接口
 *
 * @author djc
 * @since 2023-04-15 15:55:01
 */
public interface TeamService {

    /**
     * 通过ID查询单条数据
     *
     * @param teamId 主键
     * @return 实例对象
     */
    Team queryById(Integer teamId);

    /**
     * 分页查询
     *
     * @param team        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Team> queryByPage(Team team, PageRequest pageRequest);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<Team> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param team 实例对象
     * @return 实例对象
     */
    Team insert(Team team);

    /**
     * 修改数据
     *
     * @param team 实例对象
     * @return 实例对象
     */
    Team update(Team team);

    /**
     * 通过主键删除数据
     *
     * @param teamId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer teamId);

}
