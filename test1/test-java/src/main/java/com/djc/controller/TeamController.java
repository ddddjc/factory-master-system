package com.djc.controller;

import com.djc.entity.Employee;
import com.djc.entity.Team;
import com.djc.entity.Vo.QueryEmployeeVo;
import com.djc.entity.Vo.QurryTeamVo;
import com.djc.exception.CustomException;
import com.djc.service.EmployeeService;
import com.djc.service.TeamService;
import com.djc.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 小组表(Team)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("team")
public class TeamController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private TeamService teamService;
    @Autowired
    private EmployeeService employeeService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.teamService.queryById(id));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param keyword 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    @GetMapping("/findAll")
    public JsonResult<List<Team>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<Team>>(200, "查询成功", this.teamService.queryAll(keyword, page-1, num));
    }

    /**
     * 新增数据
     *
     * @param team 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<Team> add(@RequestBody Team team) {
        return new JsonResult<>(200, "新增成功", this.teamService.insert(team));
    }

    /**
     * 编辑数据
     *
     * @param team 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<Team> edit(@RequestBody Team team) {
        return new JsonResult<>(200, "修改成功", this.teamService.update(team));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.teamService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return JsonResult.error(4004,"没有此小组");
        }
    }

    /**
     * 查询小组员工
     * @param id
     * @return
     */
    @GetMapping("findEmployee/{teamId}")
    public JsonResult findEmployee(@PathVariable("teamId") Integer id){
        Employee employee=new Employee();
        employee.setTeamId(id);
        List<QueryEmployeeVo> queryEmployeeVos = employeeService.queryByCondition(employee, 1000, 0);
        return new JsonResult(200,"查询成功",queryEmployeeVos);
    }

    /**
     * 条件查询
     * @param team
     * @param num
     * @param page
     * @return
     */
    @GetMapping()
    public JsonResult findByLimit(Team team,@Param("num")Integer num,@Param("page")Integer page){
        List list = teamService.queryByLimit(team, num, page-1);
        return new JsonResult(200,"查询成功",list);
    }

    /**
     * 删除小组员工
     * @param employee
     * @return
     */
    @DeleteMapping("deleteEmployee")
    public JsonResult deleteEmployee(Employee employee){
        QurryTeamVo qurryTeamVo = teamService.queryById(employee.getTeamId());
        if (null==qurryTeamVo)
            throw new CustomException(4004,"没有此小组");
        Team team=new Team();
        team.setEmployeeNumber(qurryTeamVo.getEmployeeNumber()-1);
        team.setTeamId(employee.getTeamId());
        employee.setTeamId(0);
        teamService.update(team);
        employeeService.update(employee);
        return new JsonResult(200,"删除成功",null);
    }

    /**
     * 设置小组长
     * @param team
     * @return
     */
    @PutMapping("/setLeader")
    public JsonResult setLeader(@RequestBody Team team){
        teamService.setLeader(team);
        return new JsonResult(200,"设置成功");
    }
}
