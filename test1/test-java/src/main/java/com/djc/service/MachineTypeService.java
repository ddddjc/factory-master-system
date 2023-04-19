package com.djc.service;

import com.djc.entity.MachineType;
import com.djc.entity.Vo.AccessoriesOfMachineTypeVo;
import com.djc.entity.Vo.MachineShowVo;

import java.util.List;

/**
 * 机器类型(按种类）
 * (MachineType)表服务接口
 *
 * @author djc
 * @since 2023-04-16 14:02:09
 */
public interface MachineTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param machineTypeId 主键
     * @return 实例对象
     */
    MachineShowVo queryById(Integer machineTypeId);


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
    MachineShowVo update(MachineType machineType);

    /**
     * 通过主键删除数据
     *
     * @param machineTypeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer machineTypeId);

    List<MachineType> queryByLimit(MachineType machineType, Integer page, Integer num);
    List<MachineType> queryByLike(MachineType machineType, Integer page, Integer num);

    /**
     * 查询对应的零件
     * @param machineTypeId
     * @param num
     * @param page
     * @return
     */
    AccessoriesOfMachineTypeVo findAccessories(Integer machineTypeId, Integer num, Integer page);

    Integer queryMachineTypeNum(MachineType machineType);
}
