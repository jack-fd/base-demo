package com.github.demo.module.db2.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.demo.common.util.RestResult;
import com.github.demo.common.util.ValidatorUtils;
import com.github.demo.common.util.Query;
import com.github.demo.module.db2.model.entity.Person2;
import com.github.demo.module.db2.service.Person2Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 人员表 控制器
 *
 * @author mq
 * @date 2018-11-07
 */
@Slf4j
@RestController
@Api(tags = "人员表接口(DB2)")
@RequestMapping("/api/finance/db2/person2")
public class Person2Controller {

    @Autowired
    private Person2Service person2Service;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public RestResult<IPage<Person2>> list(@RequestBody Query query) {
        IPage<Person2> page = query.getPagination();
        QueryWrapper<Person2> queryWrapper = query.getQueryWrapper();
        return RestResult.ok(person2Service.page(page, queryWrapper));
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public RestResult<Person2> info(@PathVariable("id") Integer id) {
        Person2 entity = person2Service.getById(id);
        return RestResult.ok(entity);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RestResult<String> save(@RequestBody Person2 person2) {
        person2Service.save(person2);
        return RestResult.ok();
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public RestResult<String> update(@RequestBody Person2 person2) {
        ValidatorUtils.validateEntity(person2);
        person2Service.updateById(person2);
        return RestResult.ok();
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public RestResult<String> delete(@RequestBody Integer[] ids) {
        person2Service.removeByIds(Arrays.asList(ids));
        return RestResult.ok();
    }

}
