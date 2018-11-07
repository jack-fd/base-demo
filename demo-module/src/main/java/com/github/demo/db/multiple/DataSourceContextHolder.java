package com.github.demo.db.multiple;

/**
 * 数据源上下文环境
 *
 * @author mq
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<String> CONTEXT_HOLDER = new InheritableThreadLocal<>();

    /**
     * 设置数据源
     *
     * @param db
     */
    public static void setDataSource(String db) {
        CONTEXT_HOLDER.set(db);
    }

    /**
     * 取得当前数据源
     *
     * @return
     */
    public static String getDataSource() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清除上下文数据
     */
    public static void clear() {
        CONTEXT_HOLDER.remove();
    }
}
