package com.github.demo.module.db2.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.demo.db.multiple.annotation.DataSource;
import com.github.demo.db.multiple.enums.DataSourceEnum;
import com.github.demo.module.db2.model.entity.Person2;
import com.github.demo.module.db2.mapper.Person2Mapper;
import com.github.demo.module.db2.service.Person2Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 人员表 服务实现类
 * </p>
 *
 * @author mq
 * @since 2018-11-07
 */
@Service
public class Person2ServiceImpl extends ServiceImpl<Person2Mapper, Person2> implements Person2Service {

    @DataSource(DataSourceEnum.DB2)
    @Override
    public boolean save(Person2 entity) {
        return super.save(entity);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public boolean saveBatch(Collection<Person2> entityList, int batchSize) {
        return super.saveBatch(entityList, batchSize);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public boolean saveOrUpdate(Person2 entity) {
        return super.saveOrUpdate(entity);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public boolean saveOrUpdateBatch(Collection<Person2> entityList) {
        return super.saveOrUpdateBatch(entityList);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public boolean saveOrUpdateBatch(Collection<Person2> entityList, int batchSize) {
        return super.saveOrUpdateBatch(entityList, batchSize);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        return super.removeByMap(columnMap);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public boolean remove(Wrapper<Person2> wrapper) {
        return super.remove(wrapper);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return super.removeByIds(idList);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public boolean updateById(Person2 entity) {
        return super.updateById(entity);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public boolean update(Person2 entity, Wrapper<Person2> updateWrapper) {
        return super.update(entity, updateWrapper);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public boolean updateBatchById(Collection<Person2> entityList, int batchSize) {
        return super.updateBatchById(entityList, batchSize);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public Person2 getById(Serializable id) {
        return super.getById(id);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public Collection<Person2> listByIds(Collection<? extends Serializable> idList) {
        return super.listByIds(idList);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public Collection<Person2> listByMap(Map<String, Object> columnMap) {
        return super.listByMap(columnMap);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public Person2 getOne(Wrapper<Person2> queryWrapper, boolean throwEx) {
        return super.getOne(queryWrapper, throwEx);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public Map<String, Object> getMap(Wrapper<Person2> queryWrapper) {
        return super.getMap(queryWrapper);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public Object getObj(Wrapper<Person2> queryWrapper) {
        return super.getObj(queryWrapper);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public int count(Wrapper<Person2> queryWrapper) {
        return super.count(queryWrapper);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public List<Person2> list(Wrapper<Person2> queryWrapper) {
        return super.list(queryWrapper);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public IPage<Person2> page(IPage<Person2> page, Wrapper<Person2> queryWrapper) {
        return super.page(page, queryWrapper);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public List<Map<String, Object>> listMaps(Wrapper<Person2> queryWrapper) {
        return super.listMaps(queryWrapper);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public List<Object> listObjs(Wrapper<Person2> queryWrapper) {
        return super.listObjs(queryWrapper);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<Person2> page, Wrapper<Person2> queryWrapper) {
        return super.pageMaps(page, queryWrapper);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public boolean saveBatch(Collection<Person2> entityList) {
        return super.saveBatch(entityList);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public boolean updateBatchById(Collection<Person2> entityList) {
        return super.updateBatchById(entityList);
    }

    @DataSource(DataSourceEnum.DB2)
    @Override
    public Person2 getOne(Wrapper<Person2> queryWrapper) {
        return super.getOne(queryWrapper);
    }
}
