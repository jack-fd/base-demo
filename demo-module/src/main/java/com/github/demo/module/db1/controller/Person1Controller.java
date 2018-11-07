package com.github.demo.module.db1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.demo.common.util.RestResult;
import com.github.demo.common.util.ValidatorUtils;
import com.github.demo.common.util.Query;
import com.github.demo.module.db1.model.entity.Person1;
import com.github.demo.module.db1.service.Person1Service;
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
@Api(tags = "人员表接口")
@RequestMapping("/api/finance/db1/person1")
public class Person1Controller {

    @Autowired
    private Person1Service person1Service;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public RestResult list(@RequestBody Query query) {
        IPage<Person1> page = query.getPagination();
        QueryWrapper<Person1> queryWrapper = query.getQueryWrapper();
        return RestResult.ok(person1Service.page(page, queryWrapper));
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public RestResult info(@PathVariable("id") Integer id) {
        Person1 entity = person1Service.getById(id);
        return RestResult.ok(entity);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RestResult save(@RequestBody Person1 person1) {
        person1Service.save(person1);
        return RestResult.ok();
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public RestResult update(@RequestBody Person1 person1) {
        ValidatorUtils.validateEntity(person1);
        person1Service.updateById(person1);
        return RestResult.ok();
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public RestResult delete(@RequestBody Integer[] ids) {
        person1Service.removeByIds(Arrays.asList(ids));
        return RestResult.ok();
    }

}
