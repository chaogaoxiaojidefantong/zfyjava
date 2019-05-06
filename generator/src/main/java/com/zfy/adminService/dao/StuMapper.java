package com.zfy.adminService.dao;

import com.zfy.common.pojo.Stu;

public interface StuMapper {
    int deleteByPrimaryKey(Long stuId);

    int insert(Stu record);

    int insertSelective(Stu record);

    Stu selectByPrimaryKey(Long stuId);

    int updateByPrimaryKeySelective(Stu record);

    int updateByPrimaryKey(Stu record);
}