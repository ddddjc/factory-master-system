package com.djc.service;

import com.djc.entity.Testtable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Testtable)表服务接口
 *
 * @author djc
 * @since 2023-04-15 15:28:57
 */
public interface TesttableService {

    /**
     * 通过ID查询单条数据
     *
     * @param aaid 主键
     * @return 实例对象
     */
    Testtable queryById(Integer aaid);

    /**
     * 分页查询
     *
     * @param testtable   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Testtable> queryByPage(Testtable testtable, PageRequest pageRequest);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<Testtable> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param testtable 实例对象
     * @return 实例对象
     */
    Testtable insert(Testtable testtable);

    /**
     * 修改数据
     *
     * @param testtable 实例对象
     * @return 实例对象
     */
    Testtable update(Testtable testtable);

    /**
     * 通过主键删除数据
     *
     * @param aaid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer aaid);

}
