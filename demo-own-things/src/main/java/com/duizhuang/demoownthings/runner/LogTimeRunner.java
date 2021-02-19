package com.duizhuang.demoownthings.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * @author: yangguoxiong
 * @date: 2021/2/19 14:47
 * 步骤
 * 1. 实现CommandLineRunner
 * 2. 加入到spring容器中
 * 3. spring启动成功即会调用run方法
 */
@Component
public class LogTimeRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("spring容器启动成功");
        Stream.of(args).forEach(System.out::println);
    }
}
