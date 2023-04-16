// QurryTeamVo.java

package com.djc.entity.Vo;

import com.djc.entity.Team;

import java.util.List;

/**
 * qurryTeamVo
 */
@lombok.Data
public class QurryTeamVo extends Team {
    /**
     * 小组长id
     */
    private Integer employeeId;
    /**
     * 小组长名
     */
    private String employeeName;
    private List<QueryEmployeeVo> employees;
    /**
     * 备注
     */
    private String remark;
    /**
     * 小组id
     */
    private Integer teamId;
    /**
     * 组员
     */
    private Integer employeeNumber;
    /**
     * 小组名
     */
    private String teamName;
    /**
     * 紧急电话
     */
    private String teamNumber;
    /**
     * 小组地点
     */
    private String teamPlace;
    public void copyFromTeam(Team team) {
        setTeamId(team.getTeamId());
        setTeamName(team.getTeamName());
        setEmployeeId(team.getEmployeeId());
        setEmployeeName(team.getEmployeeName());
        setEmployeeNumber(team.getEmployeeNumber());
        setTeamNumber(team.getTeamNumber());
        setTeamPlace(team.getTeamPlace());
        setRemark(team.getRemark());
    }

}
