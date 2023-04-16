package com.djc.service;

import com.djc.entity.MaintenanceFinishUmmary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 维护完成汇总(MaintenanceFinishUmmary)表服务接口
 *
 * @author djc
 * @since 2023-04-16 14:02:14
 */
public interface MaintenanceFinishUmmaryService {

    /**
     * 通过ID查询单条数据
     *
     * @param ummmaryId 主键
     * @return 实例对象
     */
    MaintenanceFinishUmmary queryById(Integer ummmaryId);


    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<MaintenanceFinishUmmary> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param maintenanceFinishUmmary 实例对象
     * @return 实例对象
     */
    MaintenanceFinishUmmary insert(MaintenanceFinishUmmary maintenanceFinishUmmary);

    /**
     * 修改数据
     *
     * @param maintenanceFinishUmmary 实例对象
     * @return 实例对象
     */
    MaintenanceFinishUmmary update(MaintenanceFinishUmmary maintenanceFinishUmmary);

    /**
     * 通过主键删除数据
     *
     * @param ummmaryId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer ummmaryId);

}
