package com.xwl.mapping;

import com.xwl.util.ParameterMapping;

import java.util.List;

/**
 * @author xwl
 * @date 2024/7/4 10:08
 * @description
 */
public class BoundSql {
    private String finalSql;

    private List<ParameterMapping> parameterMappingList;

    public BoundSql(String finalSql, List<ParameterMapping> parameterMappingList) {
        this.finalSql = finalSql;
        this.parameterMappingList = parameterMappingList;
    }

    public String getFinalSql() {
        return finalSql;
    }

    public void setFinalSql(String finalSql) {
        this.finalSql = finalSql;
    }

    public List<ParameterMapping> getParameterMappingList() {
        return parameterMappingList;
    }

    public void setParameterMappingList(List<ParameterMapping> parameterMappingList) {
        this.parameterMappingList = parameterMappingList;
    }
}
