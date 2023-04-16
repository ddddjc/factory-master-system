package com.djc.service;

import com.djc.entity.Information;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 消息表(Information)表服务接口
 *
 * @author djc
 * @since 2023-04-16 14:02:14
 */
public interface InformationService {

    /**
     * 通过ID查询单条数据
     *
     * @param informationId 主键
     * @return 实例对象
     */
    Information queryById(Integer informationId);


    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<Information> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param information 实例对象
     * @return 实例对象
     */
    Information insert(Information information);

    /**
     * 修改数据
     *
     * @param information 实例对象
     * @return 实例对象
     */
    Information update(Information information);

    /**
     * 通过主键删除数据
     *
     * @param informationId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer informationId);

}
