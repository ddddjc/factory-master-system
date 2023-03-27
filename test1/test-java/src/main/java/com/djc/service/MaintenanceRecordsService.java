package com.djc.service;

import com.djc.entity.MaintenanceRecords;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 维修记录表
 * (MaintenanceRecords)表服务接口
 *
 * @author djc
 * @since 2023-03-21 21:59:30
 */
public interface MaintenanceRecordsService {

    /**
     * 通过ID查询单条数据
     *
     * @param recordsId 主键
     * @return 实例对象
     */
    MaintenanceRecords queryById(Integer recordsId);

    /**
     * 分页查询
     *
     * @param maintenanceRecords 筛选条件
     * @param pageRequest        分页对象
     * @return 查询结果
     */
    Page<MaintenanceRecords> queryByPage(MaintenanceRecords maintenanceRecords, PageRequest pageRequest);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<MaintenanceRecords> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param maintenanceRecords 实例对象
     * @return 实例对象
     */
    MaintenanceRecords insert(MaintenanceRecords maintenanceRecords);

    /**
     * 修改数据
     *
     * @param maintenanceRecords 实例对象
     * @return 实例对象
     */
    MaintenanceRecords update(MaintenanceRecords maintenanceRecords);

    /**
     * 通过主键删除数据
     *
     * @param recordsId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer recordsId);

    List<MaintenanceRecords> quarryByMachineId(Integer machineId);

    List<MaintenanceRecords> queryByEmployeeName(String name, Integer page, Integer num);

    void uploadFile(MultipartFile file, Integer recordsId) throws IOException;

    List<String> findFile(String type, Integer recoedId);
}
