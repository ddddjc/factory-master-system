package com.djc.service.impl;

import com.djc.entity.Information;
import com.djc.mapper.InformationMapper;
import com.djc.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 消息表(Information)表服务实现类
 *
 * @author djc
 * @since 2023-04-15 15:55:03
 */
@Service("informationService")
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationMapper informationMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param informationId 主键
     * @return 实例对象
     */
    @Override
    public Information queryById(Integer informationId) {
        return this.informationMapper.queryById(informationId);
    }

    /**
     * 分页查询
     *
     * @param information 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Information> queryByPage(Information information, PageRequest pageRequest) {
        long total = this.informationMapper.count(information);
        return new PageImpl<>(this.informationMapper.queryAllByLimit(information, pageRequest), pageRequest, total);
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
    public List<Information> queryAll(String keyWord, int page, int num) {
        return this.informationMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param information 实例对象
     * @return 实例对象
     */
    @Override
    public Information insert(Information information) {
        this.informationMapper.insert(information);
        return information;
    }

    /**
     * 修改数据
     *
     * @param information 实例对象
     * @return 实例对象
     */
    @Override
    public Information update(Information information) {
        this.informationMapper.update(information);
        return this.queryById(information.getInformationId());
    }

    /**
     * 通过主键删除数据
     *
     * @param informationId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer informationId) {
        return this.informationMapper.deleteById(informationId) > 0;
    }
}
