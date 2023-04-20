package com.djc.service.impl;

import com.djc.entity.Employee;
import com.djc.entity.Team;
import com.djc.entity.Vo.QueryEmployeeVo;
import com.djc.entity.Vo.QurryTeamVo;
import com.djc.exception.CustomException;
import com.djc.mapper.EmployeeMapper;
import com.djc.mapper.TeamMapper;
import com.djc.service.EmployeeService;
import com.djc.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 小组表(Team)表服务实现类
 *
 * @author djc
 * @since 2023-04-16 14:02:07
 */
@Service("teamService")
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeMapper employeeMapper;
    /**
     * 通过ID查询单条数据
     *
     * @param teamId 主键
     * @return 实例对象
     */
    @Override
    public QurryTeamVo queryById(Integer teamId) {
        QurryTeamVo qurryTeamVoo=new QurryTeamVo();
        Team team = teamMapper.queryById(teamId);
        qurryTeamVoo.copyFromTeam(team);
        Employee employee=new Employee();
        employee.setTeamId(teamId);
        List<QueryEmployeeVo> queryEmployeeVos = employeeService.queryByCondition(employee, 1000, 0);
        qurryTeamVoo.setEmployees(queryEmployeeVos);
        return qurryTeamVoo;
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
        return teamMapper.queryById(team.getTeamId());
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
        return team;
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

    /**
     * 条件查询
     * @param team
     * @param num
     * @param page
     * @return
     */
    @Override
    public List queryByLimit(Team team, Integer num, Integer page) {
        Sort sort=Sort.by(Sort.Direction.ASC,"teamId");
        PageRequest pageRequest=PageRequest.of(page,num,sort);
        List<Team> teams = teamMapper.queryAllByLimit(team, pageRequest);
        return teams;
    }

    /**
     * 模糊查询
     * @param team
     * @param num
     * @param page
     * @return
     */
    @Override
    public List queryByLike(Team team, Integer num, Integer page) {
        Sort sort=Sort.by(Sort.Direction.ASC,"teamId");
        PageRequest pageRequest=PageRequest.of(page,num,sort);
        List<Team> teams = teamMapper.queryAllByLike(team, pageRequest);
        return teams;
    }
    /**
     * 修改小组长
     * @param team
     */
    @Override
    public void setLeader(Team team) {
        Team team1 = teamMapper.queryById(team.getTeamId());
        QueryEmployeeVo queryEmployeeVo = employeeMapper.queryById(team.getEmployeeId());
        if (null==team1) throw new CustomException(4004,"没有该小组");
        if (null==queryEmployeeVo) throw new CustomException(4004,"没有该员工");
        Team emTeam=teamMapper.queryById(queryEmployeeVo.getTeamId());
        if (emTeam!=null){//判断在别的地方是否为组长
            if (Objects.equals(emTeam.getEmployeeId(), queryEmployeeVo.getEmployeeId()))
                throw new CustomException(5003,"该成员为"+emTeam.getTeamName()+"的组长");
            else if(!Objects.equals(emTeam.getTeamId(), team.getTeamId()))
                team.setEmployeeNumber(team1.getEmployeeNumber()+1);
            else {
                Team delTeam=new Team();
                delTeam.setTeamId(emTeam.getTeamId());
                delTeam.setEmployeeNumber(emTeam.getEmployeeNumber()-1);
                teamMapper.update(team);
            }
        }
        team.setEmployeeName(queryEmployeeVo.getEmployeeName());
        teamMapper.update(team);
        Employee employee=new Employee();
        employee.setTeamId(team.getTeamId());
        employee.setEmployeeId(team.getEmployeeId());
        employeeMapper.update(employee);
    }

    /**
     * 条件查询小组数
     * @param team
     * @return
     */
    @Override
    public Integer queryTeamNum(Team team){
        return (int) teamMapper.count(team);
    }

    @Override
    public Integer queryByLikeCount(Team team) {
        return teamMapper.queryByLikeCount(team);
    }
}
