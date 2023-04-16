package com.djc.controller;

import com.djc.entity.InformationReceiver;
import com.djc.service.InformationReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.djc.util.JsonResult;

/**
 * 消息接收者(InformationReceiver)表控制层
 *
 * @param <E> 响应数据的类型
 */
@RestController
@RequestMapping("informationReceiver")
public class InformationReceiverController<E> {
    /**
     * 服务对象
     */
    @Autowired
    private InformationReceiverService informationReceiverService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public JsonResult<InformationReceiver> queryById(@PathVariable("id") Integer id) {
        return new JsonResult<>(200, "查询成功", this.informationReceiverService.queryById(id));
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
    public JsonResult<List<InformationReceiver>> findAll(String keyword, int page, int num) {
        return new JsonResult<List<InformationReceiver>>(200, "查询成功", this.informationReceiverService.queryAll(keyword, page, num));
    }

    /**
     * 新增数据
     *
     * @param informationReceiver 实体
     * @return 新增结果
     */

    @PostMapping
    public JsonResult<InformationReceiver> add(@RequestBody InformationReceiver informationReceiver) {
        return new JsonResult<>(200, "新增成功", this.informationReceiverService.insert(informationReceiver));
    }

    /**
     * 编辑数据
     *
     * @param informationReceiver 实体
     * @return 编辑结果
     */
    @PutMapping
    public JsonResult<InformationReceiver> edit(@RequestBody InformationReceiver informationReceiver) {
        return new JsonResult<>(200, "修改成功", this.informationReceiverService.update(informationReceiver));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public JsonResult<Boolean> deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = this.informationReceiverService.deleteById(id);
        if (isDeleted) {
            return new JsonResult<>(200, "删除成功", true);
        } else {
            return new JsonResult<>(500, "删除失败", false);
        }
    }
}
