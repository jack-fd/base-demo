package com.github.demo.common.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 查询参数
 *
 * @author mq
 */
@ApiModel(description = "查询参数")
@Data
public class Query implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页", name = "current", required = true, dataType = "int", example = "0")
    private Integer current = 0;

    /**
     * 每页显示条数
     */
    @ApiModelProperty(value = "每页显示条数", required = true, dataType = "int", example = "0")
    private Integer size = 10;

    /**
     * 查询数据
     */
    @ApiModelProperty(value = "查询数据")
    private Map<String, Object> params;

    /**
     * SQL 排序 ASC 数组
     */
    @ApiModelProperty(value = "SQL 排序 ASC 数组", required = true, dataType = "string", example = "")
    private String[] ascs;

    /**
     * SQL 排序 DESC 数组
     */
    @ApiModelProperty(value = "SQL 排序 DESC 数组", required = true, dataType = "string", example = "")
    private String[] descs;

    /**
     * 获取分页参数对象
     *
     * @param <T> 类型
     * @return 分页对象
     */
    @JsonIgnore
    public <T> Page<T> getPagination() {
        Page<T> page = new Page<>(current, size);
        page.setAsc(ascs);
        page.setDesc(descs);
        return page;
    }

    /**
     * 获取查询条件
     *
     * @param <T> 类型
     * @return 查询条件
     */
    @JsonIgnore
    public <T> QueryWrapper<T> getQueryWrapper() {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        params.forEach((k, y) -> {
            queryWrapper.eq(k, y);
        });
        return queryWrapper;
    }

}
