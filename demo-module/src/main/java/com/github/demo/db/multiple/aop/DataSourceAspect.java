package com.github.demo.db.multiple.aop;

import com.github.demo.db.multiple.annotation.DataSource;
import com.github.demo.db.multiple.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 数据源AOP配置
 *
 * @author mq
 */
@Component
@Slf4j
@Aspect
@Order(-1)
public class DataSourceAspect {

    @Pointcut("@within(com.github.demo.db.multiple.annotation.DataSource) || @annotation(com.github.demo.db.multiple.annotation.DataSource)")
    public void pointCut() {

    }

    @Before("pointCut() && @annotation(dataSource)")
    public void doBefore(DataSource dataSource) {
        log.debug("切换数据源---" + dataSource.value().getValue());
        DataSourceContextHolder.setDataSource(dataSource.value().getValue());
    }

    @After("pointCut()")
    public void doAfter() {
        DataSourceContextHolder.clear();
    }
}
