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
 * @since 2023-04-16 14:02:16
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
