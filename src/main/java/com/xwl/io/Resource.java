package com.xwl.io;

import java.io.InputStream;

/**
 * @author xwl
 * @date 2024/7/4 10:06
 * @description 负责加载配置文件，加载成字节输入流，存到内存中
 */
public class Resource {
    /**
     * 根据配置文件的路径，加载配置文件成字节输入流，存到内存中
     *
     * @param path 配置文件的路径
     * @return
     */
    public static InputStream getResourceAsSteam(String path) {
        InputStream resourceAsStream = Resource.class.getClassLoader().getResourceAsStream(path);
        return resourceAsStream;
    }
}
