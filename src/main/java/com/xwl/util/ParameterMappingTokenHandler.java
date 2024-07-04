package com.xwl.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xwl
 * @date 2024/7/4 10:28
 * @description
 */
public class ParameterMappingTokenHandler implements TokenHandler {
    private List<ParameterMapping> parameterMappings = new ArrayList<ParameterMapping>();

    /**
     * 解析参数
     * @param content context是参数名称 id、username（不带#{}）
     * @return
     */
    public String handleToken(String content) {
        parameterMappings.add(buildParameterMapping(content));
        return "?";
    }

    /**
     * 构建参数映射
     * @param content context是参数名称 id、username（不带#{}）
     * @return
     */
    private ParameterMapping buildParameterMapping(String content) {
        ParameterMapping parameterMapping = new ParameterMapping(content);
        return parameterMapping;
    }

    public List<ParameterMapping> getParameterMappings() {
        return parameterMappings;
    }

    public void setParameterMappings(List<ParameterMapping> parameterMappings) {
        this.parameterMappings = parameterMappings;
    }
}
