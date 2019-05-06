package com.zfy.adminService.controller;

import com.zfy.adminService.service.StuTypeService;
import com.zfy.common.pojo.StuType;
import com.zfy.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/StuType/")
public class StuTypeController {

    @Autowired
    StuTypeService stuTypeService;

    @RequestMapping("selectOne")
        public BiliResult selectOne(StuType stuType){
       return stuTypeService.selectOne(stuType);
        }

    @RequestMapping("selectMany")
    public BiliResult selectMany(StuType stuType){
        return stuTypeService.selectMany(stuType);
    }

    @RequestMapping("selectManyAndStu")
    public BiliResult selectManyAndStu(){
        return stuTypeService.selectManyAndStu();
    }
    }
