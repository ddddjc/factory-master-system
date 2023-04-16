package com.djc.service;

import com.djc.entity.Upcoming;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 待办信息表(Upcoming)表服务接口
 *
 * @author djc
 * @since 2023-04-16 14:02:06
 */
public interface UpcomingService {

    /**
     * 通过ID查询单条数据
     *
     * @param upcomingId 主键
     * @return 实例对象
     */
    Upcoming queryById(Integer upcomingId);


    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    List<Upcoming> queryAll(String keyWord, int page, int num);

    /**
     * 新增数据
     *
     * @param upcoming 实例对象
     * @return 实例对象
     */
    Upcoming insert(Upcoming upcoming);

    /**
     * 修改数据
     *
     * @param upcoming 实例对象
     * @return 实例对象
     */
    Upcoming update(Upcoming upcoming);

    /**
     * 通过主键删除数据
     *
     * @param upcomingId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer upcomingId);

}
