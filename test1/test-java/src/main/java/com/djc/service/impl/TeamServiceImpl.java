package com.djc.service.impl;

import com.djc.entity.Team;
import com.djc.mapper.TeamMapper;
import com.djc.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 小组表(Team)表服务实现类
 *
 * @author djc
 * @since 2023-04-15 13:28:47
 */
@Service("teamService")
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamMapper teamMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param teamId 主键
     * @return 实例对象
     */
    @Override
    public Team queryById(Integer teamId) {
        return this.teamMapper.queryById(teamId);
    }

    /**
     * 分页查询
     *
     * @param team        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Team> queryByPage(Team team, PageRequest pageRequest) {
        long total = this.teamMapper.count(team);
        return new PageImpl<>(this.teamMapper.queryAllByLimit(team, pageRequest), pageRequest, total);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    @Override
    public List<Team> queryAll(String keyWord, int page, int num) {
        return this.teamMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param team 实例对象
     * @return 实例对象
     */
    @Override
    public Team insert(Team team) {
        this.teamMapper.insert(team);
        return team;
    }

    /**
     * 修改数据
     *
     * @param team 实例对象
     * @return 实例对象
     */
    @Override
    public Team update(Team team) {
        this.teamMapper.update(team);
        return this.queryById(team.getTeamId());
    }

    /**
     * 通过主键删除数据
     *
     * @param teamId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer teamId) {
        return this.teamMapper.deleteById(teamId) > 0;
    }
}
