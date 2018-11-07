package com.github.demo.db.fill.field;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * 字段填充接口
 *
 * @author mq
 */
public interface FieldFiller {

    /**
     * 字段填充
     *
     * @param metaObject 字段
     */
    void doFiller(MetaObjectHandler metaObjectHandler, MetaObject metaObject);
}
