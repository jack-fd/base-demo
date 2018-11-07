package com.github.demo.db.multiple.enums;

/**
 * 数据源枚举
 *
 * @author mq
 */
public enum DataSourceEnum {

    /**
     * 默认数据源db1
     */
    DB1("db1"),

    /**
     * 数据源db2
     */
    DB2("db2");

    private String value;

    DataSourceEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
