package com.zfy.adminService.dao;

import com.zfy.common.pojo.Comment;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CommentMapper extends Mapper<Comment> {

}
