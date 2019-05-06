package com.zfy.adminService.controller;

import com.zfy.adminService.service.UserService;
import com.zfy.common.pojo.Stu;
import com.zfy.common.pojo.User;
import com.zfy.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/User/")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 登录验证
     * @param user
     * @return
     */
    @RequestMapping("login")
    public BiliResult login(User user){
    return  userService.login(user);
    }

    /**
     * 发送邮箱验证码到用户的邮箱
     * @param user
     * @return
     */
    @RequestMapping("emailCheck")
    public BiliResult emailCheck(User user){
    return userService.sendVerifyCode(user);
    }

    @RequestMapping("registVerify")
    public BiliResult registVerify(User user){
        return userService.registVerify(user);
    }

    @RequestMapping("addOne")
    public BiliResult addOne(User user){
        return userService.addOne(user);
    }

    @RequestMapping("tokenLogin")
    public BiliResult tokenLogin(String token){
        return userService.tokenLogin(token);
    }

    @RequestMapping("logout")
    public BiliResult logout(String token){
        return userService.logout(token);
    }

    @RequestMapping("updateUser")
    public BiliResult updateUser(User user){
         return userService.updateUser(user);
    }
}
