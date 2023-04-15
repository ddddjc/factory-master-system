package com.djc.service;

import com.djc.entity.MaintenanceArrange;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 维护（保养）安排表(MaintenanceArrange)表服务接口
 *
 * @author djc
 * @since 2023-04-15 15:54:55
 */
public interface MaintenanceArrangeService {

    /**
     * 通过ID查询单条数据
     *
     * @param maintenanceArrangeId 主键
     * @return 实例对象
     */
    MaintenanceArrange queryById(Integer maintenanceArrangeId);

    /**
     * 分页查询
     *
     * @param maintenanceArrange 筛选条件
     * @param pageRequest        分页对象
     * @return 查询结果
     */
    Page<MaintenanceArrange> queryByPage(MaintenanceArrange maintenanceArrange, PageRequest pageRequest);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<MaintenanceArrange> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param maintenanceArrange 实例对象
     * @return 实例对象
     */
    MaintenanceArrange insert(MaintenanceArrange maintenanceArrange);

    /**
     * 修改数据
     *
     * @param maintenanceArrange 实例对象
     * @return 实例对象
     */
    MaintenanceArrange update(MaintenanceArrange maintenanceArrange);

    /**
     * 通过主键删除数据
     *
     * @param maintenanceArrangeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer maintenanceArrangeId);

}
