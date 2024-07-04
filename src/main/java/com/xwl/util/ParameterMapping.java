package com.xwl.util;

/**
 * @author xwl
 * @date 2024/7/4 10:27
 * @description
 */
public class ParameterMapping {
    /**
     * #{}里面的“值”：id 或 username
     */
    private String content;

    public ParameterMapping(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
