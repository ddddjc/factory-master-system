package com.djc.service;

import com.djc.entity.Team;
import com.djc.entity.Vo.QurryTeamVo;

import java.util.List;

/**
 * 小组表(Team)表服务接口
 *
 * @author djc
 * @since 2023-04-16 14:02:07
 */
public interface TeamService {

    /**
     * 通过ID查询单条数据
     *
     * @param teamId 主键
     * @return 实例对象
     */
    QurryTeamVo queryById(Integer teamId);


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

    List queryByLimit(Team team, Integer num, Integer page);


    void setLeader(Team team);

    Integer queryTeamNum(Team team);
}
