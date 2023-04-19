package com.djc.service.impl;

import com.djc.entity.Accessories;
import com.djc.entity.Machine;
import com.djc.entity.MachineType;
import com.djc.entity.Vo.MachineShowVo;
import com.djc.mapper.MachineMapper;
import com.djc.mapper.MachineTypeMapper;
import com.djc.service.MachineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 机器类型(按种类）
 * (MachineType)表服务实现类
 *
 * @author djc
 * @since 2023-04-16 14:02:09
 */
@Service("machineTypeService")
public class MachineTypeServiceImpl implements MachineTypeService {
    @Autowired
    private MachineTypeMapper machineTypeMapper;

    @Autowired
    private MachineMapper machineMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param machineTypeId 主键
     * @return 实例对象
     */
    @Override
    public MachineShowVo queryById(Integer machineTypeId) {
        MachineType machineType = machineTypeMapper.queryById(machineTypeId);
        MachineShowVo machineShowVo=new MachineShowVo();
        machineShowVo.fillFromMachineType(machineType);
        Machine machine=new Machine();
        machine.setMachineTypeId(machineTypeId);
        long count = machineMapper.count(machine);
        machineShowVo.setMachineNum((int)count);
        return machineShowVo;
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
    public MachineShowVo update(MachineType machineType) {
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

    /**
     * 条件查询
     * @param machineType
     * @param page
     * @param num
     * @return 查询集合
     */
    @Override
    public List<MachineType> queryByLimit(MachineType machineType, Integer page, Integer num) {
        Sort sort=Sort.by(Sort.Direction.ASC,"machineTypeId");
        List<MachineType> list = machineTypeMapper.queryAllByLimit(machineType, PageRequest.of(page, num, sort));
        return list;
    }

    /**
     * 查询对应的机器
     * @param machineTypeId
     * @param num
     * @param page
     * @return
     */
    @Override
    public List<Accessories> findAccessories(Integer machineTypeId, Integer num, Integer page) {
        return null;
    }

    /**
     * 查询符合条件的机器数量
     * @param machineType
     * @return
     */
    @Override
    public Integer queryMachineTypeNum(MachineType machineType) {
        return (int) machineTypeMapper.count(machineType);
    }
}
