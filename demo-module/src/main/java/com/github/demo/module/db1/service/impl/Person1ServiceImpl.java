package com.github.demo.module.db1.service.impl;

import com.github.demo.module.db1.model.entity.Person1;
import com.github.demo.module.db1.mapper.Person1Mapper;
import com.github.demo.module.db1.service.Person1Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人员表 服务实现类
 * </p>
 *
 * @author mq
 * @since 2018-11-07
 */
@Service
public class Person1ServiceImpl extends ServiceImpl<Person1Mapper, Person1> implements Person1Service {

}
