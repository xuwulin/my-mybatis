package com.xwl.session;

import java.util.List;

/**
 * @author xwl
 * @date 2024/7/4 10:36
 * @description
 */
public interface SqlSession {
    /**
     * 查询多个结果
     * sqlSession.selectList(); :定位到要执行的sql语句，从而执行
     * select * from user where username like '% ? %'
     *
     * @param statementId id
     * @param param       参数
     */
    <E> List<E> selectList(String statementId, Object param) throws Exception;

    /**
     * 查询单个结果
     *
     * @param statementId id
     * @param param       参数
     */
    <T> T selectOne(String statementId, Object param) throws Exception;

    /**
     * 清除资源
     */
    void close();

    /**
     * 生成代理对象
     *
     * @param mapperClass mapper接口
     */
    <T> T getMapper(Class<?> mapperClass);
}
