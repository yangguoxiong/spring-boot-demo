package com.xkcoding.orm.mybatis.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xkcoding.orm.mybatis.plus.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * UserMapper
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-08 16:57
 */
@Component
public interface UserMapper extends BaseMapper<User> {

    /**
     * 找到userMapper.xml对象对应的getByName的sql语句
     *
     * @param name
     * @return
     */
    List<User> getByName(@Param("name") String name);
}
