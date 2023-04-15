package com.djc.service.impl;

import com.djc.entity.RepairRequest;
import com.djc.mapper.RepairRequestMapper;
import com.djc.service.RepairRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 维修请求(RepairRequest)表服务实现类
 *
 * @author djc
 * @since 2023-04-15 15:54:53
 */
@Service("repairRequestService")
public class RepairRequestServiceImpl implements RepairRequestService {
    @Autowired
    private RepairRequestMapper repairRequestMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    @Override
    public RepairRequest queryById(Integer requestId) {
        return this.repairRequestMapper.queryById(requestId);
    }

    /**
     * 分页查询
     *
     * @param repairRequest 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    @Override
    public Page<RepairRequest> queryByPage(RepairRequest repairRequest, PageRequest pageRequest) {
        long total = this.repairRequestMapper.count(repairRequest);
        return new PageImpl<>(this.repairRequestMapper.queryAllByLimit(repairRequest, pageRequest), pageRequest, total);
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
    public List<RepairRequest> queryAll(String keyWord, int page, int num) {
        return this.repairRequestMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param repairRequest 实例对象
     * @return 实例对象
     */
    @Override
    public RepairRequest insert(RepairRequest repairRequest) {
        this.repairRequestMapper.insert(repairRequest);
        return repairRequest;
    }

    /**
     * 修改数据
     *
     * @param repairRequest 实例对象
     * @return 实例对象
     */
    @Override
    public RepairRequest update(RepairRequest repairRequest) {
        this.repairRequestMapper.update(repairRequest);
        return this.queryById(repairRequest.getRequestId());
    }

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer requestId) {
        return this.repairRequestMapper.deleteById(requestId) > 0;
    }
}
