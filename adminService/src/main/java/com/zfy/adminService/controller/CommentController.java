package com.zfy.adminService.controller;

import com.zfy.adminService.service.CommentService;
import com.zfy.common.pojo.Comment;
import com.zfy.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Comment/")
public class CommentController {

    @Autowired
    CommentService commentService;


    @RequestMapping("addOne")
    public BiliResult addOne(Comment comment){
    return  commentService.addOne(comment);
    }

    @RequestMapping("selectMany")
    public  BiliResult selectMany(Comment comment){
        return commentService.selectMany(comment);
    }
}
