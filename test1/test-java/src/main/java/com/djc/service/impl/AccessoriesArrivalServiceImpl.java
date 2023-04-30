package com.djc.service.impl;

import com.djc.entity.AccessoriesArrival;
import com.djc.entity.Vo.AccessoriesArrivalVo;
import com.djc.mapper.AccessoriesArrivalMapper;
import com.djc.service.AccessoriesArrivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 到货单(AccessoriesArrival)表服务实现类
 *
 * @author djc
 * @since 2023-04-16 14:02:15
 */
@Service("accessoriesArrivalService")
public class AccessoriesArrivalServiceImpl implements AccessoriesArrivalService {
    @Autowired
    private AccessoriesArrivalMapper accessoriesArrivalMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param arrivalId 主键
     * @return 实例对象
     */
    @Override
    public AccessoriesArrival queryById(Integer arrivalId) {
        return this.accessoriesArrivalMapper.queryById(arrivalId);
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
    public List<AccessoriesArrival> queryAll(String keyWord, int page, int num) {
        return this.accessoriesArrivalMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param accessoriesArrival 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesArrival insert(AccessoriesArrival accessoriesArrival) {
        this.accessoriesArrivalMapper.insert(accessoriesArrival);
        return accessoriesArrival;
    }

    /**
     * 修改数据
     *
     * @param accessoriesArrival 实例对象
     * @return 实例对象
     */
    @Override
    public AccessoriesArrival update(AccessoriesArrival accessoriesArrival) {
        this.accessoriesArrivalMapper.update(accessoriesArrival);
        return this.queryById(accessoriesArrival.getArrivalId());
    }

    /**
     * 通过主键删除数据
     *
     * @param arrivalId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer arrivalId) {
        return this.accessoriesArrivalMapper.deleteById(arrivalId) > 0;
    }

    @Override
    public List<AccessoriesArrival> queryByLike(AccessoriesArrival accessoriesArrival, Integer page, Integer num) {
        return accessoriesArrivalMapper.queryByLike(accessoriesArrival, PageRequest.of(page,num));
    }

    @Override
    public Integer likeNum(AccessoriesArrival accessoriesArrival) {
        return accessoriesArrivalMapper.likeNum(accessoriesArrival);
    }

    @Override
    public AccessoriesArrivalVo queryVoById(Integer id) {
        return accessoriesArrivalMapper.queryVoById(id);
    }
}
