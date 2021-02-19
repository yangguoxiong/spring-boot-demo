package com.duizhuang.demoownthings.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: yangguoxiong
 * @date: 2021/2/19 15:15
 * @description:
 */
@RestController
public class LoginController {

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        return "返回成功";
    }
}
