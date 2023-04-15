package com.djc.service;

import com.djc.entity.File;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 文件表(File)表服务接口
 *
 * @author djc
 * @since 2023-04-15 15:29:03
 */
public interface FileService {

    /**
     * 通过ID查询单条数据
     *
     * @param fileId 主键
     * @return 实例对象
     */
    File queryById(Integer fileId);

    /**
     * 分页查询
     *
     * @param file        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<File> queryByPage(File file, PageRequest pageRequest);

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<File> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param file 实例对象
     * @return 实例对象
     */
    File insert(File file);

    /**
     * 修改数据
     *
     * @param file 实例对象
     * @return 实例对象
     */
    File update(File file);

    /**
     * 通过主键删除数据
     *
     * @param fileId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer fileId);

}
