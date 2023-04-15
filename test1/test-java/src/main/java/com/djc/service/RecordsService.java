package com.djc.service;

import com.djc.entity.Records;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 维修(维修)记录表
 * (Records)表服务接口
 *
 * @author djc
 * @since 2023-04-15 15:55:08
 */
public interface RecordsService {

    /**
     * 通过ID查询单条数据
     *
     * @param recordsId 主键
     * @return 实例对象
     */
    Records queryById(Integer recordsId);

    /**
     * 分页查询
     *
     * @param records     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Records> queryByPage(Records records, PageRequest pageRequest);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<Records> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param records 实例对象
     * @return 实例对象
     */
    Records insert(Records records);

    /**
     * 修改数据
     *
     * @param records 实例对象
     * @return 实例对象
     */
    Records update(Records records);

    /**
     * 通过主键删除数据
     *
     * @param recordsId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer recordsId);

}
