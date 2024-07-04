package com.xwl.builder;

import com.alibaba.druid.pool.DruidDataSource;
import com.xwl.io.Resource;
import com.xwl.mapping.Configuration;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @author xwl
 * @date 2024/7/4 10:40
 * @description xml配置文件解析器
 */
public class XMLConfigBuilder {
    private Configuration configuration;

    public XMLConfigBuilder() {
        this.configuration = new Configuration();
    }

    /**
     * 使用dom4j+xpath解析配置文件，封装Configuration对象
     *
     * @param inputStream
     * @return
     */
    public Configuration parse(InputStream inputStream) throws DocumentException {

        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();

        // xpath解析property节点：<property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
        List<Element> list = rootElement.selectNodes("//property");
        // 封装到Properties对象中
        Properties properties = new Properties();
        for (Element element : list) {
            String name = element.attributeValue("name");
            String value = element.attributeValue("value");
            properties.setProperty(name, value);
        }

        // 创建数据源对象
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(properties.getProperty("driverClassName"));
        druidDataSource.setUrl(properties.getProperty("url"));
        druidDataSource.setUsername(properties.getProperty("username"));
        druidDataSource.setPassword(properties.getProperty("password"));

        // 创建好的数据源对象封装到Configuration对象中
        configuration.setDataSource(druidDataSource);

        /**
         * xpath解析mapper节点（映射配置文件）：<mapper resource="mapper/UserMapper.xml"></mapper>
         * 1.获取映射配置文件的路径
         * 2.根据路径进行映射配置文件的加载解析
         * 3.封装到MappedStatement --> 封装到configuration里面的map集合中
         */
        List<Element> mapperList = rootElement.selectNodes("//mapper");
        for (Element element : mapperList) {
            // mapper配置文件的路径
            String mapperPath = element.attributeValue("resource");
            InputStream resourceAsSteam = Resource.getResourceAsSteam(mapperPath);
            // XMLMapperBuilder：专门解析映射配置文件的对象
            XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(configuration);
            xmlMapperBuilder.parse(resourceAsSteam);
        }
        return configuration;
    }
}
