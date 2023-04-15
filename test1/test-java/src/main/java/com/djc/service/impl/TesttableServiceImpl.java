package com.djc.service.impl;

import com.djc.entity.Testtable;
import com.djc.mapper.TesttableMapper;
import com.djc.service.TesttableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Testtable)表服务实现类
 *
 * @author djc
 * @since 2023-04-15 13:28:44
 */
@Service("testtableService")
public class TesttableServiceImpl implements TesttableService {
    @Autowired
    private TesttableMapper testtableMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param aaid 主键
     * @return 实例对象
     */
    @Override
    public Testtable queryById(Integer aaid) {
        return this.testtableMapper.queryById(aaid);
    }

    /**
     * 分页查询
     *
     * @param testtable   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Testtable> queryByPage(Testtable testtable, PageRequest pageRequest) {
        long total = this.testtableMapper.count(testtable);
        return new PageImpl<>(this.testtableMapper.queryAllByLimit(testtable, pageRequest), pageRequest, total);
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
    public List<Testtable> queryAll(String keyWord, int page, int num) {
        return this.testtableMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param testtable 实例对象
     * @return 实例对象
     */
    @Override
    public Testtable insert(Testtable testtable) {
        this.testtableMapper.insert(testtable);
        return testtable;
    }

    /**
     * 修改数据
     *
     * @param testtable 实例对象
     * @return 实例对象
     */
    @Override
    public Testtable update(Testtable testtable) {
        this.testtableMapper.update(testtable);
        return this.queryById(testtable.getAaid());
    }

    /**
     * 通过主键删除数据
     *
     * @param aaid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer aaid) {
        return this.testtableMapper.deleteById(aaid) > 0;
    }
}
