package com.djc.service;

import com.djc.entity.MachineType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 机器类型(MachineType)表服务接口
 *
 * @author djc
 * @since 2023-03-19 19:14:22
 */
public interface MachineTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param machineTypeId 主键
     * @return 实例对象
     */
    MachineType queryById(Integer machineTypeId);

    /**
     * 分页查询
     *
     * @param machineType 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<MachineType> queryByPage(MachineType machineType, PageRequest pageRequest);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<MachineType> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param machineType 实例对象
     * @return 实例对象
     */
    MachineType insert(MachineType machineType);

    /**
     * 修改数据
     *
     * @param machineType 实例对象
     * @return 实例对象
     */
    MachineType update(MachineType machineType);

    /**
     * 通过主键删除数据
     *
     * @param machineTypeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer machineTypeId);

}
