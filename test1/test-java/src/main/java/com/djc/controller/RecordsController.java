package com.djc.controller;

import com.djc.entity.Records;
import com.djc.exception.CustomException;
import com.djc.service.FileService;
import com.djc.service.MachineTypeService;
import com.djc.service.RecordsService;
import com.djc.util.FileTypeUtils;
import com.djc.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 维修(维修)记录表
 * (Records)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("records")
public class RecordsController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private RecordsService recordsService;

    @Autowired
    private MachineTypeService machineTypeService;

    @Autowired
    private FileService fileService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult queryById(@PathVariable("id") Integer id) {
        Records records = this.recordsService.queryById(id);
        com.djc.entity.File file=new com.djc.entity.File();
        file.setRecordsId(id);
        List<com.djc.entity.File> files = fileService.queryByLimit(file, 0, 100);
        Map map=new HashMap();
        map.put("fileList",files);
        map.put("records",records);
        return new JsonResult<>(200, "查询成功",map);
    }

    @GetMapping()
    public JsonResult queryAllByLike(Records records,@Param("page")Integer page,@Param("num")Integer num){
        if (page<1||num<1) throw new CustomException(4005,"页数和数量应该大于零");
        List<Records> recordsList=recordsService.queryAllByLike(records,page-1,num);
        Integer total=recordsService.queryLikeCount(records);
        Map map=new HashMap();
        map.put("recordsList",recordsList);
        map.put("total",total);
        return new JsonResult(200,"查询成功",map);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param keyword 关键字
     * @param page    页码
     * @param num     每页数量
     * @return 多条数据
     */
    @GetMapping("/findAll")
    public JsonResult<List<Records>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<Records>>(200, "查询成功", this.recordsService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param records 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<Records> add(@RequestBody Records records) {
        records.setRecordsState(0);
        return new JsonResult<>(200, "新增成功", this.recordsService.insert(records));
    }

    /**
     * 编辑数据
     *
     * @param records 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<Records> edit(Records records) {
        return new JsonResult<>(200, "修改成功", this.recordsService.update(records));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.recordsService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }

    /**
     * 上传文件
     * @param file
     * @param recordsId
     * @return
     */
    @Value("${file.path}")
    private String fileLocation;
    @PostMapping("/file")
    public JsonResult addfile(@RequestPart("file")MultipartFile file, @Param("recordsId")Integer recordsId) throws IOException {
        String originalFilename = file.getOriginalFilename();
        long time = new Date().getTime();
        String filename=""+recordsId+time+originalFilename;
        file.transferTo(new File(fileLocation+ filename));
        String fileType = FileTypeUtils.getFileType(file);
        String filePlace="http://43.142.234.223:8089/lr/"+filename;
        com.djc.entity.File myFile=new com.djc.entity.File(null,recordsId,filePlace,fileType,(int)file.getSize());
        recordsService.addFile(myFile,recordsId);
        return new JsonResult(200,"插入成功");
    }

    /**
     * 删除文件
     * @param fileId
     * @return
     */
    @DeleteMapping("file/{fileId}")
    public JsonResult delFile(@PathVariable("fileId") Integer fileId){
        recordsService.delFile(fileId);
        return new JsonResult(200,"删除成功");
    }

    /**
     * 查询机器类型对应的维修记录
     * @param machineTypeId
     * @param page
     * @param num
     * @return
     */
    @GetMapping("findByMachineType/{machineTypeId}")
    public JsonResult findByMachineType(@PathVariable("machineTypeId")Integer machineTypeId,@Param("page")Integer page,@Param("num")Integer num){
        Records records=new Records();
        records.setMachineTypeId(machineTypeId);
        List<Records> recordsList=recordsService.queryByLimit(records,page-1,num);
        Integer total=recordsService.queryCount(records);
        Map map=new HashMap();
        map.put("total",total);
        map.put("recordsList",recordsList);
        return new JsonResult(200,"查询成功",map);
    }

    /**
     * 根据维修查询文件
     * @param recordsId
     * @param page
     * @param num
     * @return
     */
    @GetMapping("file/{recordsId}")
    public JsonResult findFileByRecordsId(@PathVariable("recordsId") Integer recordsId,@Param("page")Integer page,@Param("num")Integer num){
        if (page<1||num<1) throw new CustomException(4009,"page和num不应该小于一");
        com.djc.entity.File file=new com.djc.entity.File();
        List<com.djc.entity.File> files=fileService.queryByLimit(file,page-1,num);
        Integer total =fileService.queryCount(file);
        Map map=new HashMap();
        map.put("total",total);
        map.put("fileList",files);
        return new JsonResult<>(200,"查询成功",map);
    }

    /**
     * 查询未通过的
     * @param page
     * @param num
     * @return
     */
    @GetMapping("audit")
    public JsonResult audit(@Param("page")Integer page,@Param("num")Integer num){
        Records records = new Records();
        records.setRecordsState(0);
        return queryAllByLike(records,page,num);
    }

    /**
     * 修改维修记录状态
     * @param recordsId
     * @param result
     * @return
     */
    @PutMapping("audit")
    public JsonResult updateState(@Param("recordsId")Integer recordsId,@Param("result")Integer result){
        if (result.equals(1)){
            Records records=new Records();
            records.setRecordsState(1);
            records.setRecordsId(recordsId);
            recordsService.update(records);
            return new JsonResult<>(200,"修改成功");
        }else return new JsonResult(200,"审核成功");
    }
}
