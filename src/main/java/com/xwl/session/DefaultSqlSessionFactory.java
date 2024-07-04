package com.xwl.session;

import com.xwl.executor.Executor;
import com.xwl.executor.SimpleExecutor;
import com.xwl.mapping.Configuration;

/**
 * @author xwl
 * @date 2024/7/4 10:37
 * @description
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        // 1.创建执行器对象
        Executor simpleExecutor = new SimpleExecutor();

        // 2.生产sqlSession对象
        DefaultSqlSession defaultSqlSession = new DefaultSqlSession(configuration, simpleExecutor);

        return defaultSqlSession;
    }
}
