package com.djc.service.impl;

import com.djc.entity.File;
import com.djc.entity.Records;
import com.djc.exception.CustomException;
import com.djc.mapper.FileMapper;
import com.djc.mapper.RecordsMapper;
import com.djc.service.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 维修(维修)记录表
 * (Records)表服务实现类
 *
 * @author djc
 * @since 2023-04-19 21:57:06
 */
@Service("recordsService")
public class RecordsServiceImpl implements RecordsService {
    @Autowired
    private RecordsMapper recordsMapper;

    @Autowired
    private FileMapper fileMapper;
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

    @Override
    public void addFile(File myFile, Integer recordsId) {
        Records records = recordsMapper.queryById(recordsId);
        if (records==null) throw new CustomException(4006,"维修记录不存在");
        int insert = fileMapper.insert(myFile);
    }

    @Value("${file.path}")
    String directory;
    @Override
    public void delFile(Integer fileId) {
        File file = fileMapper.queryById(fileId);
        if (file==null) throw new CustomException(4006,"文件不存在");
        String filePlace = directory+file.getFilePlace();
        java.io.File file1=new java.io.File(filePlace);
        if (!file1.delete()) throw new CustomException(4002,"删除失败");
        fileMapper.deleteById(fileId);
    }

    @Override
    public List<Records> queryAllByLike(Records records, Integer page, Integer num) {
        return recordsMapper.queryAllByLike(records, PageRequest.of(page,num));
    }

    @Override
    public Integer queryLikeCount(Records records) {
        return recordsMapper.queryByLikeCount(records);
    }

    @Override
    public List<Records> queryByLimit(Records records, Integer page, Integer num) {
        return recordsMapper.queryAllByLimit(records,PageRequest.of(page,num));
    }

    @Override
    public Integer queryCount(Records records) {
        return (int) recordsMapper.count(records);
    }
}
