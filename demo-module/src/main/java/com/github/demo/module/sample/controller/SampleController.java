package com.github.demo.module.sample.controller;

import com.github.demo.common.util.RestResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 检查程序是否已经启动
 *
 * @author mq
 */
@Slf4j
@RestController
@Api(tags = "检查程是否已经启动")
@RequestMapping("/api/demo/sample")
public class SampleController {

    @ApiOperation("查看程序是否启动")
    @RequestMapping(value = "/sample", method = RequestMethod.GET)
    public RestResult sample() {
        return RestResult.ok("Hello Demo!");
    }
}
