package com.djc.service;

import com.djc.entity.Depot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 仓库信息
 * (Depot)表服务接口
 *
 * @author djc
 * @since 2023-04-15 15:28:51
 */
public interface DepotService {

    /**
     * 通过ID查询单条数据
     *
     * @param depotId 主键
     * @return 实例对象
     */
    Depot queryById(Integer depotId);

    /**
     * 分页查询
     *
     * @param depot       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Depot> queryByPage(Depot depot, PageRequest pageRequest);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<Depot> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param depot 实例对象
     * @return 实例对象
     */
    Depot insert(Depot depot);

    /**
     * 修改数据
     *
     * @param depot 实例对象
     * @return 实例对象
     */
    Depot update(Depot depot);

    /**
     * 通过主键删除数据
     *
     * @param depotId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer depotId);

}
