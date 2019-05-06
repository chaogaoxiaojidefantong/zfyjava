package com.zfy.adminService.controller;

import com.zfy.adminService.service.StuService;
import com.zfy.common.pojo.Stu;
import com.zfy.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/Stu/")
public class StuController {
    @Autowired
    StuService stuService;

    @RequestMapping("stuUpload")
    public BiliResult stuUpload(MultipartFile file, Stu stu){
        return stuService.stuUpload(file,stu);
    }

    @RequestMapping("selectByName")
    public BiliResult selectByName(String stuName){
        return stuService.selectByName(stuName);
    }

    @RequestMapping("selectMany")
    public BiliResult selectMany(Stu stu){
        return stuService.selectMany(stu);
    }

    @RequestMapping("selectOne")
    public BiliResult selectOne(Stu stu){
        return stuService.selectOne(stu);
    }
}
