package com.zfy.adminService.controller;

import com.zfy.adminService.service.UserService;
import com.zfy.common.pojo.User;
import com.zfy.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User/")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("login")
    public BiliResult login(User user){
    return  userService.login(user);
    }

}
