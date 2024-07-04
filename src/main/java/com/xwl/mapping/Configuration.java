package com.xwl.mapping;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xwl
 * @date 2024/7/4 10:23
 * @description 全局配置类：存放核心配置文件mybatis-config.xml解析出来的内容
 */
public class Configuration {
    /**
     * 数据源对象
     */
    private DataSource dataSource;

    /**
     * key: statementId(namespace.id)   MappedStatement: 封装好的MappedStatement对象
     */
    private Map<String, MappedStatement> mappedStatementMap = new HashMap();

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<String, MappedStatement> getMappedStatementMap() {
        return mappedStatementMap;
    }

    public void setMappedStatementMap(Map<String, MappedStatement> mappedStatementMap) {
        this.mappedStatementMap = mappedStatementMap;
    }
}
