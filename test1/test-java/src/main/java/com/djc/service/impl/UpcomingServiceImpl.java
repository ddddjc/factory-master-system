package com.djc.service.impl;

import com.djc.entity.Upcoming;
import com.djc.mapper.UpcomingMapper;
import com.djc.service.UpcomingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 待办信息表(Upcoming)表服务实现类
 *
 * @author djc
 * @since 2023-04-15 15:28:52
 */
@Service("upcomingService")
public class UpcomingServiceImpl implements UpcomingService {
    @Autowired
    private UpcomingMapper upcomingMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param upcomingId 主键
     * @return 实例对象
     */
    @Override
    public Upcoming queryById(Integer upcomingId) {
        return this.upcomingMapper.queryById(upcomingId);
    }

    /**
     * 分页查询
     *
     * @param upcoming    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Upcoming> queryByPage(Upcoming upcoming, PageRequest pageRequest) {
        long total = this.upcomingMapper.count(upcoming);
        return new PageImpl<>(this.upcomingMapper.queryAllByLimit(upcoming, pageRequest), pageRequest, total);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param keyWord 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    @Override
    public List<Upcoming> queryAll(String keyWord, int page, int num) {
        return this.upcomingMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param upcoming 实例对象
     * @return 实例对象
     */
    @Override
    public Upcoming insert(Upcoming upcoming) {
        this.upcomingMapper.insert(upcoming);
        return upcoming;
    }

    /**
     * 修改数据
     *
     * @param upcoming 实例对象
     * @return 实例对象
     */
    @Override
    public Upcoming update(Upcoming upcoming) {
        this.upcomingMapper.update(upcoming);
        return this.queryById(upcoming.getUpcomingId());
    }

    /**
     * 通过主键删除数据
     *
     * @param upcomingId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer upcomingId) {
        return this.upcomingMapper.deleteById(upcomingId) > 0;
    }
}
