package com.djc.service.impl;

import com.djc.entity.File;
import com.djc.entity.MaintenanceRecords;
import com.djc.mapper.FileMapper;
import com.djc.mapper.MaintenanceRecordsMapper;
import com.djc.service.MaintenanceRecordsService;
import com.djc.util.FileTypeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * 维修记录表
 * (MaintenanceRecords)表服务实现类
 *
 * @author djc
 * @since 2023-03-21 21:59:30
 */
@Service("maintenanceRecordsService")
public class MaintenanceRecordsServiceImpl implements MaintenanceRecordsService {
    @Autowired
    private MaintenanceRecordsMapper maintenanceRecordsMapper;
    @Autowired
    FileMapper fileMapper;
    /**
     * 通过ID查询单条数据
     *
     * @param recordsId 主键
     * @return 实例对象
     */
    @Override
    public MaintenanceRecords queryById(Integer recordsId) {
        return this.maintenanceRecordsMapper.queryById(recordsId);
    }

    /**
     * 分页查询
     *
     * @param maintenanceRecords 筛选条件
     * @param pageRequest        分页对象
     * @return 查询结果
     */
    @Override
    public Page<MaintenanceRecords> queryByPage(MaintenanceRecords maintenanceRecords, PageRequest pageRequest) {
        long total = this.maintenanceRecordsMapper.count(maintenanceRecords);
        return new PageImpl<>(this.maintenanceRecordsMapper.queryAllByLimit(maintenanceRecords, pageRequest), pageRequest, total);
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
    public List<MaintenanceRecords> queryAll(String keyWord, int page, int num) {
        return this.maintenanceRecordsMapper.queryAll(keyWord, (page - 1) * num, num);
    }

    /**
     * 新增数据
     *
     * @param maintenanceRecords 实例对象
     * @return 实例对象
     */
    @Override
    public MaintenanceRecords insert(MaintenanceRecords maintenanceRecords) {
        this.maintenanceRecordsMapper.insert(maintenanceRecords);
        return maintenanceRecords;
    }

    /**
     * 修改数据
     *
     * @param maintenanceRecords 实例对象
     * @return 实例对象
     */
    @Override
    public MaintenanceRecords update(MaintenanceRecords maintenanceRecords) {
        this.maintenanceRecordsMapper.update(maintenanceRecords);
        return this.queryById(maintenanceRecords.getRecordsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param recordsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer recordsId) {
        return this.maintenanceRecordsMapper.deleteById(recordsId) > 0;
    }

    @Override
    public List<MaintenanceRecords> quarryByMachineId(Integer machineId) {
        return maintenanceRecordsMapper.queryByMachineId(machineId);
    }

    @Override
    public List<MaintenanceRecords> queryByEmployeeName(String name, Integer page, Integer num) {
        return maintenanceRecordsMapper.queryByEmployeeName(name,(page-1)*num,num);
    }

    @Override
    public void uploadFile(MultipartFile file, Integer recordsId) throws IOException {
        String fileName=file.getOriginalFilename();
        File file1=new File();
        file1.setFileType(FileTypeUtils.getFileType(file));
        byte[] bytes = file.getBytes();
        String path = "D:testFile/"+recordsId+ fileName;
        file1.setFilePlace(path);
        file1.setRecordsId(recordsId);
        int insert = fileMapper.insert(file1);
        if (insert!=0){
            // 创建文件输出流对象
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(bytes);
            fos.close();
        }
        System.out.println(insert);
    }

    @Override
    public List<String> findFile(String type, Integer recoedId) {
        return fileMapper.findFile(type,recoedId);
    }
}
