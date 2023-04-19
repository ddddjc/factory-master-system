package com.djc.service;

import com.djc.entity.Machine;

import java.util.List;

/**
 * 设备表(具体到台)(Machine)表服务接口
 *
 * @author djc
 * @since 2023-04-17 16:21:21
 */
public interface MachineService {

    /**
     * 通过ID查询单条数据
     *
     * @param machineId 主键
     * @return 实例对象
     */
    Machine queryById(Integer machineId);


    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<Machine> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param machine 实例对象
     * @return 实例对象
     */
    Machine insert(Machine machine);

    /**
     * 修改数据
     *
     * @param machine 实例对象
     * @return 实例对象
     */
    Machine update(Machine machine);

    /**
     * 通过主键删除数据
     *
     * @param machineId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer machineId);

    List queryByLimit(Machine machine, Integer page, Integer num);

    Integer queryMachineNum(Machine machine);
}
