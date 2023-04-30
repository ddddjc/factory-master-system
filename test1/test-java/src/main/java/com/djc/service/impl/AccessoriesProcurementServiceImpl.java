package com.djc.service.impl;

import com.djc.entity.AccessoriesProcurement;
import com.djc.entity.Vo.AccessoriesProcurementVo;
import com.djc.mapper.AccessoriesProcurementMapper;
import com.djc.service.AccessoriesProcurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 采购信息(AccessoriesProcurement)表服务实现类
 *
 * @author djc
 * @since 2023-04-16 14:02:07
 */
@Service("accessoriesProcurementService")
public class AccessoriesProcurementServiceImpl implements AccessoriesProcurementService {
    @Autowired
    private AccessoriesProcurementMapper accessoriesProcurementMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param procurementId 主键
     * @return 实例对象
     */
    @Override
    public AccessoriesProcurement queryById(Integer procurementId) {
        return this.accessoriesProcurementMapper.queryById(procurementId);
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
    public List<AccessoriesProcurement> queryAll(String keyWord, int page, int num) {
        return this.accessoriesProcurementMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param accessoriesProcurement 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesProcurement insert(AccessoriesProcurement accessoriesProcurement) {
        this.accessoriesProcurementMapper.insert(accessoriesProcurement);
        return accessoriesProcurement;
    }

    /**
     * 修改数据
     *
     * @param accessoriesProcurement 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesProcurement update(AccessoriesProcurement accessoriesProcurement) {
        this.accessoriesProcurementMapper.update(accessoriesProcurement);
        return this.queryById(accessoriesProcurement.getProcurementId());
    }

    /**
     * 通过主键删除数据
     *
     * @param procurementId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer procurementId) {
        return this.accessoriesProcurementMapper.deleteById(procurementId) > 0;
    }

    @Override
    public List<AccessoriesProcurement> queryByLike(AccessoriesProcurement accessoriesProcurement, Integer page, Integer num) {
        return accessoriesProcurementMapper.queryByLike(accessoriesProcurement, PageRequest.of(page,num));
    }

    @Override
    public Integer likeNum(AccessoriesProcurement accessoriesProcurement) {
        return accessoriesProcurementMapper.LikeNum(accessoriesProcurement);
    }

    @Override
    public AccessoriesProcurementVo queryVoById(Integer id) {
        return accessoriesProcurementMapper.queryVoById(id);
    }
}
