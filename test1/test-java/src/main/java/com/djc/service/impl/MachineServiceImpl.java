package com.djc.service.impl;

import com.djc.entity.Machine;
import com.djc.mapper.MachineMapper;
import com.djc.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 设备表(具体到台)(Machine)表服务实现类
 *
 * @author djc
 * @since 2023-04-15 15:29:05
 */
@Service("machineService")
public class MachineServiceImpl implements MachineService {
    @Autowired
    private MachineMapper machineMapper;

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
     * 分页查询
     *
     * @param machine     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Machine> queryByPage(Machine machine, PageRequest pageRequest) {
        long total = this.machineMapper.count(machine);
        return new PageImpl<>(this.machineMapper.queryAllByLimit(machine, pageRequest), pageRequest, total);
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
}
