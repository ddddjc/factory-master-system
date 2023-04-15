package com.djc.service;

import com.djc.entity.RepairRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 维修请求(RepairRequest)表服务接口
 *
 * @author djc
 * @since 2023-04-15 15:28:56
 */
public interface RepairRequestService {

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    RepairRequest queryById(Integer requestId);

    /**
     * 分页查询
     *
     * @param repairRequest 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    Page<RepairRequest> queryByPage(RepairRequest repairRequest, PageRequest pageRequest);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<RepairRequest> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param repairRequest 实例对象
     * @return 实例对象
     */
    RepairRequest insert(RepairRequest repairRequest);

    /**
     * 修改数据
     *
     * @param repairRequest 实例对象
     * @return 实例对象
     */
    RepairRequest update(RepairRequest repairRequest);

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer requestId);

}
