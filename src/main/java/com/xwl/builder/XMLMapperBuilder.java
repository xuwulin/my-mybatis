package com.xwl.builder;

import com.xwl.mapping.Configuration;
import com.xwl.mapping.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * @author xwl
 * @date 2024/7/4 10:40
 * @description 映射配置文件解析器：mapper.xml --> mappedStatement --> 封装到configuration里面的map集合中
 */
public class XMLMapperBuilder {
    private Configuration configuration;

    public XMLMapperBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * 解析mapper.xml文件，将<select>、<insert>、<update>、<delete>标签中的内容封装到mappedStatement中
     *
     * @param resourceAsSteam
     * @throws DocumentException
     */
    public void parse(InputStream resourceAsSteam) throws DocumentException {

        Document document = new SAXReader().read(resourceAsSteam);
        Element rootElement = document.getRootElement();

        /**
         *  <select id="selectOne" resultType="com.xwl.pojo.User" parameterType="com.xwl.pojo.User">
         *         select * from user where id = #{id} and username = #{username}
         *  </select>
         */
        List<Element> selectList = rootElement.selectNodes("//select");
        String namespace = rootElement.attributeValue("namespace");
        for (Element element : selectList) {

            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String parameterType = element.attributeValue("parameterType");
            String sql = element.getTextTrim();

            // 封装mappedStatement对象
            MappedStatement mappedStatement = new MappedStatement();

            // StatementId:namespace.id
            String statementId = namespace + "." + id;
            mappedStatement.setStatementId(statementId);
            mappedStatement.setResultType(resultType);
            mappedStatement.setParameterType(parameterType);
            mappedStatement.setSql(sql);
            mappedStatement.setSqlCommandType("select");

            // 将封装好的mappedStatement封装到configuration中的map集合中
            configuration.getMappedStatementMap().put(statementId, mappedStatement);
        }
    }
}
