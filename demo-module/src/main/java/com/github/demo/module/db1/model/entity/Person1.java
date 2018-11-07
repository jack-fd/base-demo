package com.github.demo.module.db1.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.time.LocalDateTime;

/**
 * 人员表
 *
 * @author mq
 * @date 2018-11-07
 */
@Data
@TableName("db1_person1")
public class Person1 implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 编号
     */
    @TableId
    private Integer id;

    /**
     * 创建时间
     */
    @JsonIgnore
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    @JsonIgnore
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    /**
     * 创建用户
     */
    @JsonIgnore
    @TableField(fill = FieldFill.INSERT)
    private Integer userCreate;

    /**
     * 修改用户
     */
    @JsonIgnore
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer userModified;

    /**
     * 逻辑删除:1正常, 0删除
     */
    @JsonIgnore
    @TableLogic
    private Integer deleted;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

}
