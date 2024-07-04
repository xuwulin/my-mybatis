package com.xwl.session;

/**
 * @author xwl
 * @date 2024/7/4 10:35
 * @description
 */
public interface SqlSessionFactory {
    /**
     * 1.生产sqlSession对象 2.创建执行器对象
     * @return
     */
    SqlSession openSession();
}
