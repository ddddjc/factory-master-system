package com.djc.service;

import com.djc.entity.File;

import java.util.List;

/**
 * 文件表(File)表服务接口
 *
 * @author djc
 * @since 2023-04-20 11:10:08
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

    List<File> queryByLimit(File file, int i, Integer num);

    Integer queryCount(File file);
}
