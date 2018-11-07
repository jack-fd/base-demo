package com.github.demo.db.fill;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.github.demo.db.fill.field.FieldFiller;
import com.github.demo.db.fill.field.impl.GmtCreateFieldFiller;
import com.github.demo.db.fill.field.impl.GmtModifiedFieldFiller;
import com.github.demo.db.fill.field.impl.UserCreateFieldFiller;
import com.github.demo.db.fill.field.impl.UserModifiedFieldFiller;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;

import java.util.List;

/**
 * 填充器
 *
 * @author mq
 */
@Slf4j
public class DemoMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        List<FieldFiller> fillers = Lists.newArrayList();
        fillers.add(new GmtCreateFieldFiller());
        fillers.add(new UserCreateFieldFiller());
        fillers.add(new GmtModifiedFieldFiller());
        fillers.add(new UserModifiedFieldFiller());
        for (FieldFiller filler : fillers) {
            filler.doFiller(this, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        List<FieldFiller> fillers = Lists.newArrayList();
        fillers.add(new GmtModifiedFieldFiller());
        fillers.add(new UserModifiedFieldFiller());
        for (FieldFiller filler : fillers) {
            filler.doFiller(this, metaObject);
        }
    }
}
