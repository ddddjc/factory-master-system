package com.djc.service.impl;

import com.djc.entity.Machine;
import com.djc.entity.MachineType;
import com.djc.entity.Vo.MachienVo;
import com.djc.mapper.MachineMapper;
import com.djc.mapper.MachineTypeMapper;
import com.djc.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备表(具体到台)(Machine)表服务实现类
 *
 * @author djc
 * @since 2023-04-17 16:21:21
 */
@Service("machineService")
public class MachineServiceImpl implements MachineService {
    @Autowired
    private MachineMapper machineMapper;

    @Autowired
    private MachineTypeMapper machineTypeMapper;
    /**
     * 通过ID查询单条数据
     *
     * @param machineId 主键
     * @return 实例对象
     */
    @Override
    public Machine queryById(Integer machineId) {
        return this.machineMapper.queryById(machineId);
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
    public List<Machine> queryAll(String keyWord, int page, int num) {
        return this.machineMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param machine 实例对象
     * @return 实例对象
     */
    @Override
    public Machine insert(Machine machine) {
        this.machineMapper.insert(machine);
        return machine;
    }

    /**
     * 修改数据
     *
     * @param machine 实例对象
     * @return 实例对象
     */
    @Override
    public Machine update(Machine machine) {
        this.machineMapper.update(machine);
        return this.queryById(machine.getMachineId());
    }

    /**
     * 通过主键删除数据
     *
     * @param machineId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer machineId) {
        return this.machineMapper.deleteById(machineId) > 0;
    }

    /**
     * 条件查询机器展示信息MachienVo
     * @param machine
     * @param page
     * @param num
     * @return
     */
    @Override
    public List<MachienVo> queryByLimit(Machine machine, Integer page, Integer num) {
        List<Machine> machines = machineMapper.queryAllByLimit(machine, PageRequest.of(page, num));
        List<MachienVo> machienVos=new ArrayList<>();
        for (Machine m:machines) {
            MachienVo machienVo = Machine.toMachienVo(m);
            MachineType machineType = machineTypeMapper.queryById(m.getMachineTypeId());
            machienVo.mergeMachineType(machineType);
            machienVos.add(machienVo);
        }
        return machienVos;
    }

    /**
     * 模糊查询
     * @param machine
     * @param page
     * @param num
     * @return
     */
    @Override
    public List<MachienVo> queryByLike(Machine machine, Integer page, Integer num) {
        List<Machine> machines = machineMapper.queryAllByLike(machine, PageRequest.of(page, num));
        List<MachienVo> machienVos=new ArrayList<>();
        for (Machine m:machines) {
            MachienVo machienVo = Machine.toMachienVo(m);
            MachineType machineType = machineTypeMapper.queryById(m.getMachineTypeId());
            machienVo.mergeMachineType(machineType);
            machienVos.add(machienVo);
        }
        return machienVos;
    }
    /**
     * 查询符合条件的数量
     * @param machineType
     * @return
     */
    @Override
    public Integer queryMachineNum(Machine machine) {
        return (int) machineMapper.count(machine);
    }

    /**
     * 查询模糊对应总数
     * @param machine
     * @return
     */
    @Override
    public Integer queryByLikeCount(Machine machine) {
        return machineMapper.queryByLikeCount(machine);
    }
}
