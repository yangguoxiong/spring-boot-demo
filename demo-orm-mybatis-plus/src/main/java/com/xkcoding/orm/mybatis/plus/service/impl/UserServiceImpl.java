package com.xkcoding.orm.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.orm.mybatis.plus.entity.User;
import com.xkcoding.orm.mybatis.plus.mapper.UserMapper;
import com.xkcoding.orm.mybatis.plus.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * User Service
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-08 18:10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> getByName(String name) {

        /**
         * 方式一: 手动@Autowired private UserMapper userMapper;
         *
         * 方式二: 从父类ServiceImpl获得mapper, 查看源码, ServiceImpl已经定义了getBaseMapper()的方法, 返回的也是你定义的UserMapper对象
         */
        return this.getBaseMapper().getByName(name);
    }
}
