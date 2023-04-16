package com.djc.service.impl;

import com.djc.entity.Records;
import com.djc.mapper.RecordsMapper;
import com.djc.service.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 维修(维修)记录表
 * (Records)表服务实现类
 *
 * @author djc
 * @since 2023-04-15 15:55:08
 */
@Service("recordsService")
public class RecordsServiceImpl implements RecordsService {
    @Autowired
    private RecordsMapper recordsMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param recordsId 主键
     * @return 实例对象
     */
    @Override
    public Records queryById(Integer recordsId) {
        return this.recordsMapper.queryById(recordsId);
    }

    /**
     * 分页查询
     *
     * @param records     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Records> queryByPage(Records records, PageRequest pageRequest) {
        long total = this.recordsMapper.count(records);
        return new PageImpl<>(this.recordsMapper.queryAllByLimit(records, pageRequest), pageRequest, total);
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
    public List<Records> queryAll(String keyWord, int page, int num) {
        return this.recordsMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param records 实例对象
     * @return 实例对象
     */
    @Override
    public Records insert(Records records) {
        this.recordsMapper.insert(records);
        return records;
    }

    /**
     * 修改数据
     *
     * @param records 实例对象
     * @return 实例对象
     */
    @Override
    public Records update(Records records) {
        this.recordsMapper.update(records);
        return this.queryById(records.getRecordsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param recordsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer recordsId) {
        return this.recordsMapper.deleteById(recordsId) > 0;
    }
}