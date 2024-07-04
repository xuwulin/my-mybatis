package com.xwl.executor;

import com.xwl.mapping.Configuration;
import com.xwl.mapping.MappedStatement;

import java.util.List;

/**
 * @author xwl
 * @date 2024/7/4 10:38
 * @description
 */
public interface Executor {
    <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object param) throws Exception;

    void close();
}
