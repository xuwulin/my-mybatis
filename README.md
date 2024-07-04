# 自定义框架本身大概步骤
1. 加载配置文件：根据配置文件的路径，加载配置文件成字节输入流，存储在内存中。
    - 创建Resource类：负责加载配置文件，加载成字节输入流，存到内存中
    - 方法：InputStream getResourceAsSteam(String path);

2. 创建两个javaBean（容器对象）：存放配置文件解析出来的内容
    - Configuration（全局配置类）：存放核心配置文件mybatis-config.xml解析出来的内容
    - MappedStatement（映射配置类）：存放mapper.xml配置文件解析出来的内容

3. 解析配置文件（使用dom4j） ，并创建SqlSession会话对象
    - 创建SqlSessionFactoryBuilder类：构建SqlSessionFactory
    - 方法：SqlSessionFactory build(InputStream inputStream);
        - 使用dom4j解析配置文件，将解析出来的内容封装到容器对象Configuration中；
        - 创建SqlSessionFactory对象，生产sqlSession会话对象（工厂模式）

4. 创建SqlSessionFactory接口以及实现类DefaultSqlSessionFactory（工厂模式）
    - 方法：SqlSession openSession(); 生成sqlSession对象

5. 创建SqlSession接口以及实现类DefaultSqlSession
    - 定义对数据库的CRUD操作：
        - selectList();
        - selectOne();
        - update();
        - delete();

6. 创建Executor接口以及实现类SimpleExecutor
    - 创建query(Configuration configuration, MappedStatement mappedStatement, Object param);方法，实际执行的就是JDBC代码。