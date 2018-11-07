package com.github.demo.db.fill.field.impl;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.github.demo.db.fill.field.FieldFiller;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;

/**
 * 创建用户填充器
 *
 * @author mq
 */
@Slf4j
public class UserCreateFieldFiller implements FieldFiller {

    /**
     * 属性名称
     */
    private static final String FIELD_NAME = "userCreate";

    @Override
    public void doFiller(MetaObjectHandler metaObjectHandler, MetaObject metaObject) {
        if (metaObject.hasSetter(FIELD_NAME)) {
            log.debug("start insert fill {}", FIELD_NAME);
            metaObjectHandler.setFieldValByName(FIELD_NAME, 0, metaObject);
        }
    }
}
