package com.zfy.adminService.service;

import com.zfy.adminService.dao.CommentMapper;
import com.zfy.common.pojo.Comment;
import com.zfy.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentMapper commentMapper;

    /**
     * 评论
     * @return
     */
    public BiliResult addOne(Comment comment){
    Integer i1=commentMapper.insert(comment);
    if(i1==0){
        return BiliResult.build(201,"评论失败");
    }
    return BiliResult.oK();
    }

    /**
     * 查看某资源的评论
     * @param comment
     * @return
     */
    public BiliResult selectMany(Comment comment){
        List<Comment>list=commentMapper.select(comment);
        return BiliResult.oK(list);
    }
}
