package com.djc.service.impl;

import com.djc.entity.MachineType;
import com.djc.mapper.MachineTypeMapper;
import com.djc.service.MachineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 机器类型(按种类）
 * (MachineType)表服务实现类
 *
 * @author djc
 * @since 2023-04-15 15:54:57
 */
@Service("machineTypeService")
public class MachineTypeServiceImpl implements MachineTypeService {
    @Autowired
    private MachineTypeMapper machineTypeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param machineTypeId 主键
     * @return 实例对象
     */
    @Override
    public MachineType queryById(Integer machineTypeId) {
        return this.machineTypeMapper.queryById(machineTypeId);
    }

    /**
     * 分页查询
     *
     * @param machineType 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<MachineType> queryByPage(MachineType machineType, PageRequest pageRequest) {
        long total = this.machineTypeMapper.count(machineType);
        return new PageImpl<>(this.machineTypeMapper.queryAllByLimit(machineType, pageRequest), pageRequest, total);
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
    public List<MachineType> queryAll(String keyWord, int page, int num) {
        return this.machineTypeMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param machineType 实例对象
     * @return 实例对象
     */
    @Override
    public MachineType insert(MachineType machineType) {
        this.machineTypeMapper.insert(machineType);
        return machineType;
    }

    /**
     * 修改数据
     *
     * @param machineType 实例对象
     * @return 实例对象
     */
    @Override
    public MachineType update(MachineType machineType) {
        this.machineTypeMapper.update(machineType);
        return this.queryById(machineType.getMachineTypeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param machineTypeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer machineTypeId) {
        return this.machineTypeMapper.deleteById(machineTypeId) > 0;
    }
}
