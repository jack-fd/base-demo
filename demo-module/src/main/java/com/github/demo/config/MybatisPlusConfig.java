package com.github.demo.config;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.github.demo.db.multiple.enums.DataSourceEnum;
import com.github.demo.db.fill.DemoMetaObjectHandler;
import com.github.demo.db.multiple.MultipleDataSource;
import com.google.common.collect.Maps;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

/**
 * MybatisPlus 配置
 *
 * @author mq
 */
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {

    /**
     * 数据源1
     *
     * @return 默认数据源
     */
    @Bean(name = "db1")
    @ConfigurationProperties(prefix = "spring.datasource.druid.db1")
    public DataSource db1() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 数据源2
     *
     * @return 物流账户数据源
     */
    @Bean(name = "db2")
    @ConfigurationProperties(prefix = "spring.datasource.druid.db2")
    public DataSource db2() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 动态数据源配置
     *
     * @return 自定义数据源
     */
    @Bean
    @Primary
    public DataSource multipleDataSource(@Qualifier("db1") DataSource db1, @Qualifier("db2") DataSource db2) {
        MultipleDataSource multipleDataSource = new MultipleDataSource();
        Map<Object, Object> targetDataSources = Maps.newHashMap();
        targetDataSources.put(DataSourceEnum.DB1.getValue(), db1);
        targetDataSources.put(DataSourceEnum.DB2.getValue(), db2);
        //添加数据源
        multipleDataSource.setTargetDataSources(targetDataSources);
        //设置默认数据源
        multipleDataSource.setDefaultTargetDataSource(db1);
        return multipleDataSource;
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 构建填充器
     *
     * @return 填充器
     */
    @Bean("metaObjectHandler")
    public MetaObjectHandler metaObjectHandler() {
        return new DemoMetaObjectHandler();
    }

    /**
     * Mybatis 配置
     *
     * @param metaObjectHandler 填充器
     * @return SqlSessionFactory
     * @throws Exception 异常
     */
    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(MetaObjectHandler metaObjectHandler, PaginationInterceptor paginationInterceptor) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        // 配置多数据源
        sqlSessionFactory.setDataSource(multipleDataSource(db1(), db2()));
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*/*Mapper.xml"));
        // 实体扫描，多个package用逗号或者分号分隔
        sqlSessionFactory.setTypeAliasesPackage("com.github.demo.module.*.model.entity");

        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        // 主键类型  AUTO:"数据库ID自增", INPUT:"用户输入ID",ID_WORKER:"全局唯一ID (数字类型唯一ID)", UUID:"全局唯一ID UUID";
        dbConfig.setIdType(IdType.AUTO);
        // 字段策略 IGNORED:"忽略判断",NOT_NULL:"非 NULL 判断"),NOT_EMPTY:"非空判断"
        dbConfig.setFieldStrategy(FieldStrategy.NOT_NULL);
        // 数据库大写下划线转换
        dbConfig.setCapitalMode(true);
        // 逻辑删除配置
        dbConfig.setLogicDeleteValue("1");
        dbConfig.setLogicNotDeleteValue("0");
        dbConfig.setDbType(DbType.MYSQL);

        GlobalConfig globalConfig = new GlobalConfig();
        //#刷新mapper 调试神器
        globalConfig.setRefresh(true);
        globalConfig.setDbConfig(dbConfig);
        globalConfig.setMetaObjectHandler(metaObjectHandler);
        sqlSessionFactory.setGlobalConfig(globalConfig);

        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        configuration.setCallSettersOnNulls(true);
        sqlSessionFactory.setConfiguration(configuration);

        sqlSessionFactory.setPlugins(new Interceptor[]{
                //添加分页功能
                paginationInterceptor
        });
        return sqlSessionFactory.getObject();
    }

}
