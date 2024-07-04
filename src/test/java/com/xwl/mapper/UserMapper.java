package com.xwl.mapper;

import com.xwl.pojo.User;

import java.util.List;

/**
 * @author xwl
 * @date 2024/7/4 11:20
 * @description
 */
public interface UserMapper {
    /**
     * 查询所有
     */
    List<User> findAll() throws Exception;

    /**
     * 根据多条件查询
     */
    User findByCondition(User user) throws Exception;
}
