package com.djc.service;

import com.djc.entity.AccessEcords;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 库存变更记录(AccessEcords)表服务接口
 *
 * @author djc
 * @since 2023-03-19 19:14:19
 */
public interface AccessEcordsService {

    /**
     * 通过ID查询单条数据
     *
     * @param accessRecordsId 主键
     * @return 实例对象
     */
    AccessEcords queryById(Integer accessRecordsId);

    /**
     * 分页查询
     *
     * @param accessEcords 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    Page<AccessEcords> queryByPage(AccessEcords accessEcords, PageRequest pageRequest);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<AccessEcords> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param accessEcords 实例对象
     * @return 实例对象
     */
    AccessEcords insert(AccessEcords accessEcords);

    /**
     * 修改数据
     *
     * @param accessEcords 实例对象
     * @return 实例对象
     */
    AccessEcords update(AccessEcords accessEcords);

    /**
     * 通过主键删除数据
     *
     * @param accessRecordsId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer accessRecordsId);

}
