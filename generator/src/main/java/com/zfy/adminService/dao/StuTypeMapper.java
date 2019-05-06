package com.zfy.adminService.dao;

import com.zfy.common.pojo.StuType;

public interface StuTypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(StuType record);

    int insertSelective(StuType record);

    StuType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(StuType record);

    int updateByPrimaryKey(StuType record);
}