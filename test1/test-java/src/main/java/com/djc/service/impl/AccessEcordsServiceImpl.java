package com.djc.service.impl;

import com.djc.entity.AccessEcords;
import com.djc.mapper.AccessEcordsMapper;
import com.djc.service.AccessEcordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 库存变更记录(AccessEcords)表服务实现类
 *
 * @author djc
 * @since 2023-03-21 21:59:31
 */
@Service("accessEcordsService")
public class AccessEcordsServiceImpl implements AccessEcordsService {
    @Autowired
    private AccessEcordsMapper accessEcordsMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param accessRecordsId 主键
     * @return 实例对象
     */
    @Override
    public AccessEcords queryById(Integer accessRecordsId) {
        return this.accessEcordsMapper.queryById(accessRecordsId);
    }

    /**
     * 分页查询
     *
     * @param accessEcords 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    @Override
    public Page<AccessEcords> queryByPage(AccessEcords accessEcords, PageRequest pageRequest) {
        long total = this.accessEcordsMapper.count(accessEcords);
        return new PageImpl<>(this.accessEcordsMapper.queryAllByLimit(accessEcords, pageRequest), pageRequest, total);
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
    public List<AccessEcords> queryAll(String keyWord, int page, int num) {
        return this.accessEcordsMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param accessEcords 实例对象
     * @return 实例对象
     */
    @Override
    public AccessEcords insert(AccessEcords accessEcords) {
        this.accessEcordsMapper.insert(accessEcords);
        return accessEcords;
    }

    /**
     * 修改数据
     *
     * @param accessEcords 实例对象
     * @return 实例对象
     */
    @Override
    public AccessEcords update(AccessEcords accessEcords) {
        this.accessEcordsMapper.update(accessEcords);
        return this.queryById(accessEcords.getAccessRecordsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param accessRecordsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer accessRecordsId) {
        return this.accessEcordsMapper.deleteById(accessRecordsId) > 0;
    }
}
