package com.djc.service.impl;

import com.djc.entity.InformationReceiver;
import com.djc.mapper.InformationReceiverMapper;
import com.djc.service.InformationReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 消息接收者(InformationReceiver)表服务实现类
 *
 * @author djc
 * @since 2023-04-15 13:28:53
 */
@Service("informationReceiverService")
public class InformationReceiverServiceImpl implements InformationReceiverService {
    @Autowired
    private InformationReceiverMapper informationReceiverMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param receiverId 主键
     * @return 实例对象
     */
    @Override
    public InformationReceiver queryById(Integer receiverId) {
        return this.informationReceiverMapper.queryById(receiverId);
    }

    /**
     * 分页查询
     *
     * @param informationReceiver 筛选条件
     * @param pageRequest         分页对象
     * @return 查询结果
     */
    @Override
    public Page<InformationReceiver> queryByPage(InformationReceiver informationReceiver, PageRequest pageRequest) {
        long total = this.informationReceiverMapper.count(informationReceiver);
        return new PageImpl<>(this.informationReceiverMapper.queryAllByLimit(informationReceiver, pageRequest), pageRequest, total);
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
    public List<InformationReceiver> queryAll(String keyWord, int page, int num) {
        return this.informationReceiverMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param informationReceiver 实例对象
     * @return 实例对象
     */
    @Override
    public InformationReceiver insert(InformationReceiver informationReceiver) {
        this.informationReceiverMapper.insert(informationReceiver);
        return informationReceiver;
    }

    /**
     * 修改数据
     *
     * @param informationReceiver 实例对象
     * @return 实例对象
     */
    @Override
    public InformationReceiver update(InformationReceiver informationReceiver) {
        this.informationReceiverMapper.update(informationReceiver);
        return this.queryById(informationReceiver.getReceiverId());
    }

    /**
     * 通过主键删除数据
     *
     * @param receiverId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer receiverId) {
        return this.informationReceiverMapper.deleteById(receiverId) > 0;
    }
}
